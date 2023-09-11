package ru.neotoria.gempl.user_timezone_service.web;

import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.neotoria.gempl.microservices.user_timezone_service.api.TimezoneApi;
import ru.neotoria.gempl.microservices.user_timezone_service.payload.request.SearchTimezoneRequest;
import ru.neotoria.gempl.microservices.user_timezone_service.payload.response.TimezoneMultipleResponse;
import ru.neotoria.gempl.microservices.user_timezone_service.payload.response.TimezoneResponse;
import ru.neotoria.gempl.user_timezone_service.domain.mapper.TimezoneMapper;
import ru.neotoria.gempl.user_timezone_service.domain.service.TimezoneService;


@RestController
@RequiredArgsConstructor
public class TimezoneController implements TimezoneApi {
    private final TimezoneMapper timezoneMapper;
    private final TimezoneService timezoneService;


    @Override
    public TimezoneResponse getTimezoneById(@PathVariable Long id) {
        return timezoneMapper.toTimezoneResponse
                (
                        timezoneService.get(id)
                );
    }

    @Override
    public TimezoneMultipleResponse getTimezones() {
        return timezoneMapper.toTimezonesResponse
                (
                        timezoneService.get()
                );
    }

    @Override
    public TimezoneMultipleResponse searchTimezone(SearchTimezoneRequest request) {
        return timezoneMapper.toTimezonesResponse
                (
                        timezoneService.searchTimezone
                                (
                                        request.key(),
                                        request.offsetAfter(),
                                        request.offsetBefore()
                                )
                );
    }
}
