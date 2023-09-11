package ru.neotoria.gempl.user_timezone_service.core.interceptor;

import feign.InvocationContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.ResponseInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.neotoria.gempl.user_timezone_service.core.config.InstanceConfig;

import java.util.Collection;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestInstanceInterceptor implements RequestInterceptor, ResponseInterceptor {

    private final InstanceConfig config;

    @Override
    public void apply(RequestTemplate template) {
        template.header(config.getRequestAppName(), config.getAppName());
        template.header(config.getRequestIdName(), config.getAppId());
    }

    @Override
    public Object aroundDecode(InvocationContext invocationContext){

        Map<String, Collection<String>> headers = invocationContext
                .response()
                .headers();

        Collection<String> instanceKey = headers.get(config.getResponseAppName());
        Collection<String> instanceId = headers.get(config.getResponseIdName());
        if (!instanceKey.isEmpty()) {
            instanceKey
                    .stream()
                    .findFirst()
                    .ifPresent(key -> log.info("Response instance name: " + key));
        }
        if (!instanceId.isEmpty()) {
            instanceId
                    .stream()
                    .findFirst()
                    .ifPresent(id -> log.info("Response instance id: " + id));
        }

        return invocationContext.proceed();
    }
}
