package ru.neotoria.gempl.user_timezone_service.core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import ru.neotoria.gempl.user_timezone_service.core.config.InstanceConfig;

@Slf4j
@Component
@RequiredArgsConstructor
public class ResponseInstanceInterceptor implements HandlerInterceptor {

    private final InstanceConfig config;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String instanceKey = request
                .getHeader(config.getRequestAppName());
        String instanceId = request
                .getHeader(config.getRequestIdName());

        if (instanceKey != null) {
            log.info("Request instance name: " + instanceKey);

        }
        if (instanceId != null) {
            log.info("Request instance id: " + instanceId);
        }

        response.addHeader(config.getResponseAppName(), config.getAppName());
        response.addHeader(config.getResponseIdName(), config.getAppId());

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
