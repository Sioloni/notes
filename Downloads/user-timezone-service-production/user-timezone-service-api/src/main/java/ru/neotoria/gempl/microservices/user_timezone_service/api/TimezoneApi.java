package ru.neotoria.gempl.microservices.user_timezone_service.api;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.neotoria.gempl.microservices.user_timezone_service.api.router.TimezoneRouter;
import ru.neotoria.gempl.microservices.user_timezone_service.payload.request.SearchTimezoneRequest;
import ru.neotoria.gempl.microservices.user_timezone_service.payload.response.TimezoneMultipleResponse;
import ru.neotoria.gempl.microservices.user_timezone_service.payload.response.TimezoneResponse;

@LoadBalancerClient
@FeignClient("user-timezone-service")
public interface TimezoneApi {

    @PostMapping(TimezoneRouter.ID.ROOT)
    TimezoneResponse getTimezoneById(@PathVariable Long id);

    @PostMapping(TimezoneRouter.ROOT)
    TimezoneMultipleResponse getTimezones();

    @PostMapping(TimezoneRouter.SEARCH)
    TimezoneMultipleResponse searchTimezone(@RequestBody SearchTimezoneRequest request);

}
