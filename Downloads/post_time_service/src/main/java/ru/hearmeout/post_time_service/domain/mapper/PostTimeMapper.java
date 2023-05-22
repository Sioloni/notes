package ru.hearmeout.post_time_service.domain.mapper;

import org.springframework.stereotype.Component;
import ru.hearmeout.post_time_service.PostTimeCurrentRequest;
import ru.hearmeout.post_time_service.PostTimeMultipleResponse;
import ru.hearmeout.post_time_service.PostTimeResponse;
import ru.hearmeout.post_time_service.domain.entity.PostTime;
import ru.hearmeout.timezone_service.AccountTimezoneRequest;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostTimeMapper {

    public PostTimeMultipleResponse toMultipleResponse(List<PostTime> entities){
        return PostTimeMultipleResponse.newBuilder()
                .addAllData(entities.stream()
                        .map(this::toResponse)
                        .collect(Collectors.toList()))
                .build();
    }


    public PostTimeResponse toResponse(PostTime entity){
        return PostTimeResponse.newBuilder()
                .setId(entity.getId().toString())
                .setKey(entity.getKey())
                .setStartsAt(entity.getStartAt())
                .build();
    }

    public AccountTimezoneRequest toAccountTimezoneRequest(PostTimeCurrentRequest request){
        return AccountTimezoneRequest.newBuilder()
                .setAccountId(request.getAccountId())
                .build();
    }
}
