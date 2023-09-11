package ru.neotoria.gempl.microservices.common_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<GlobalExceptionBody> handleGlobalException(GlobalException ex) {
        return ResponseEntity.status(ex.getError().getStatus())
                .body(new GlobalExceptionBody(
                        ex.getError().getStatus(),
                        ex.getMessage(),
                        LocalDateTime.now(),
                        ex.getData()
                ));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GlobalExceptionBody> handleAnyInternalException(Exception ex) {
        GlobalException gatewayException = GlobalException.of(ex);

        return ResponseEntity.status(gatewayException.
                getError().
                getStatus()
        ).body(
                new GlobalExceptionBody(
                        gatewayException.getError().getStatus(),
                        gatewayException.getMessage(),
                        LocalDateTime.now(),
                        gatewayException.getData()
                )
        );
    }

}
