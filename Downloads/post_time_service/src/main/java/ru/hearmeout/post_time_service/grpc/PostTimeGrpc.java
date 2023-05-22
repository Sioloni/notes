package ru.hearmeout.post_time_service.grpc;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hearmeout.post_time_service.*;
import ru.hearmeout.post_time_service.core.config.AccountService;
import ru.hearmeout.post_time_service.domain.mapper.PostTimeMapper;
import ru.hearmeout.post_time_service.domain.repository.PostTimeRepository;
import ru.hearmeout.post_time_service.tools.StreamObserverUtils;
import ru.hearmeout.timezone_service.TimezoneResponse;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostTimeGrpc extends PostTimeServiceGrpc.PostTimeServiceImplBase {
    private final PostTimeRepository repository;
    private final PostTimeMapper mapper;
    private final AccountService accountService;


    @Override
    public void getPostTimes(Empty request, StreamObserver<PostTimeMultipleResponse> responseObserver) {
        StreamObserverUtils.submit(responseObserver, mapper.toMultipleResponse(repository.findAll()));
    }

    @Override
    public void getPostTimeById(PostTimeIdRequest request, StreamObserver<PostTimeResponse> responseObserver) {
        StreamObserverUtils.submit(responseObserver, mapper.toResponse(repository.getEntityById(UUID.fromString(request.getId()))));
    }

    @Override
    public void existPostTimeById(PostTimeIdRequest request, StreamObserver<PostTimeResponse> responseObserver) {
        PostTimeResponse entityResponse = null;
        boolean resultExist = repository.existsById(UUID.fromString(request.getId()));
        if (resultExist) {
            entityResponse = mapper.toResponse(repository.getEntityById(UUID.fromString(request.getId())));
        }
        StreamObserverUtils.submit(responseObserver, entityResponse);
    }

    @Override
    public void getCurrent(PostTimeCurrentRequest request, StreamObserver<PostTimeResponse> responseObserver) {
        TimezoneResponse timezoneResponse = accountService.defaultChannelBlockingStub().getAccountTimezone(mapper.toAccountTimezoneRequest(request));
        LocalDateTime localDateTimeNew = LocalDateTime.now();
        LocalDateTime localDateTimeCast = localDateTimeNew.plusSeconds(timezoneResponse.getOffset());
        StreamObserverUtils.submit(responseObserver,
                mapper.toResponse(repository.findByStartAtAfter(localDateTimeCast)
                        .orElseThrow(() -> new RuntimeException("Local date time not found"))));
    }
}
