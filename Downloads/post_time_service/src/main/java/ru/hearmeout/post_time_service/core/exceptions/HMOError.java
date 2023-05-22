package ru.hearmeout.post_time_service.core.exceptions;

import io.grpc.Status;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HMOError {

    UNKNOWN_ERROR(0L, Status.INTERNAL),
    NOT_FOUND_BY_ID(1L, Status.NOT_FOUND),
    NOT_FOUND_BY_KEY(2L, Status.NOT_FOUND);


    private final Long code;
    private final io.grpc.Status status;
}
