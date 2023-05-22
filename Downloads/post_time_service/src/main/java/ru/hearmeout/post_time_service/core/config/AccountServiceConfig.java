package ru.hearmeout.post_time_service.core.config;


import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "grpc.client.timezone_service")
public class AccountServiceConfig {
    private String address;
    private Integer port;

    interface Qualifiers {
        interface Channel {
            String DEFAULT = "AccountServiceConfig#DEFAULT_CHANNEL";
        }
    }
    @Bean
    @Qualifier(Qualifiers.Channel.DEFAULT)
    public Channel accountserviceDefaultChannel() {
        return ManagedChannelBuilder.forAddress(
                this.address,
                this.port
        ).usePlaintext().build();
    }



}
