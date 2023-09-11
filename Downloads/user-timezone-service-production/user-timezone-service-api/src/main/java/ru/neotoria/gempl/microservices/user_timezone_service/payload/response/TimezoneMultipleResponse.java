package ru.neotoria.gempl.microservices.user_timezone_service.payload.response;

import ru.neotoria.gempl.microservices.user_timezone_service.payload.request.TimezoneIdRequest;

import java.util.Collection;

public record TimezoneMultipleResponse
        (
                Collection<TimezoneResponse> data
        ) {
}
