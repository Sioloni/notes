package ru.neotoria.gempl.user_timezone_service.domain.mapper;


import org.springframework.stereotype.Component;
import ru.neotoria.gempl.microservices.user_timezone_service.payload.response.TimezoneResponse;
import ru.neotoria.gempl.microservices.user_timezone_service.payload.response.TimezoneMultipleResponse;
import ru.neotoria.gempl.user_timezone_service.domain.entity.Timezone;


import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class TimezoneMapper {

    public TimezoneResponse toTimezoneResponse(Timezone entity) {
        return new TimezoneResponse
                (
                        entity.getId(),
                        entity.getKey(),
                        entity.getOffset()
                );
    }

    public TimezoneMultipleResponse toTimezonesResponse(Collection<Timezone> timezones) {
        return new TimezoneMultipleResponse
                (
                        timezones.stream()
                                .map(this::toTimezoneResponse)
                                .collect(Collectors.toList())
                );
    }
}
