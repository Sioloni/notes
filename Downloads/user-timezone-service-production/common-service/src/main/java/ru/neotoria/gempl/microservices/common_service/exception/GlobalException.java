package ru.neotoria.gempl.microservices.common_service.exception;

import lombok.Getter;
import ru.neotoria.gempl.microservices.common_service.util.ParseUtil;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class GlobalException extends RuntimeException {

    private final GlobalError error;
    private final Map<String, Object> data = new LinkedHashMap<>();


    private GlobalException(GlobalError error) {
        super(error.name());
        this.error = error;
    }

    private GlobalException(GlobalError error, String message) {
        super(message);
        this.error = error;
    }

    private GlobalException(GlobalError error,
                            String message,
                            Map<String, Object> data) {
        super(message);
        this.error = error;
        this.data.putAll(data);
    }

    private GlobalException(GlobalError error,
                            Map<String, Object> data) {
        super(error.name());
        this.error = error;
        this.data.putAll(data);
    }


    public static GlobalException of(GlobalError error) {
        return new GlobalException(error);
    }

    public static GlobalException of(GlobalError error, String message) {
        return new GlobalException(error, message);
    }

    public static GlobalException of(
            GlobalError error,
            Map<String, Object> data
    ) {
        return new GlobalException(
                error,
                data
        );
    }

    public static GlobalException of(
            GlobalError error,
            String message,
            Map<String, Object> data
    ) {
        return new GlobalException(
                error,
                message,
                data
        );
    }

    public static GlobalException of(Exception exception) {
        if (exception instanceof GlobalException) {
            return (GlobalException) exception;
        }

        return new GlobalException(
                GlobalError.INTERNAL_ERROR,
                exception.getMessage(),
                ParseUtil.stacktraceToMap(
                        exception.getStackTrace()
                )
        );
    }
}
