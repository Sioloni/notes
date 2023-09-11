package ru.neotoria.gempl.user_timezone_service.core.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.neotoria.gempl.user_timezone_service.core.interceptor.ResponseInstanceInterceptor;

@Component
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final ResponseInstanceInterceptor responseInstanceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(responseInstanceInterceptor);
    }
}
