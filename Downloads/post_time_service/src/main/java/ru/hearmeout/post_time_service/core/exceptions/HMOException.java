package ru.hearmeout.post_time_service.core.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class HMOException extends RuntimeException {
    private final HMOError error;
    private final Map<String, Object> data = new HashMap<>();

    public static HMOException of(Exception exception) {
        if (exception.getClass().isAssignableFrom(HMOException.class)) {
            return (HMOException) exception;
        }

        return new HMOException(HMOError.UNKNOWN_ERROR);
    }
}
