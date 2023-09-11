package ru.neotoria.gempl.microservices.user_timezone_service.payload.request;

public record SearchTimezoneRequest
        (
                String key,
                Integer offsetAfter,
                Integer offsetBefore
        ) {
}
