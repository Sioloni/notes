package ru.neotoria.gempl.microservices.user_timezone_service.payload.response;

public record TimezoneResponse
        (
                Long id,
                String key,
                Integer offset
        ) {
}
