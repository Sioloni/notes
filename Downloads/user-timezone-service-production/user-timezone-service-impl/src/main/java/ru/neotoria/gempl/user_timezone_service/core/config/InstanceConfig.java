package ru.neotoria.gempl.user_timezone_service.core.config;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Component
public class InstanceConfig {

    private final EurekaClient eurekaClient;

    public InstanceConfig(EurekaClient eurekaClient) {

        InstanceInfo info = eurekaClient
                .getApplicationInfoManager()
                .getInfo();

        this.eurekaClient = eurekaClient;
        this.appName = info.getAppName();
        this.appId = info.getId();

        log.info("Instance started with key:" + appName);
        log.info("Instance started with id:" + appId);
    }

    private final String appName;
    private final String appId;
    private final String requestAppName = "REQUEST-INSTANCE-APP-NAME";
    private final String responseAppName = "RESPONSE-INSTANCE-APP-NAME";
    private final String requestIdName = "REQUEST-INSTANCE-APP-ID";
    private final String responseIdName = "RESPONSE-INSTANCE-APP-ID";
}
