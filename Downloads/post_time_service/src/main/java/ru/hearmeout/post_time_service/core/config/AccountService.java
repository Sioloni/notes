package ru.hearmeout.post_time_service.core.config;

import io.grpc.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hearmeout.timezone_service.TimezoneServiceGrpc;

@Component
public class AccountService {

    @Autowired
    @Qualifier(AccountServiceConfig.Qualifiers.Channel.DEFAULT)
    private Channel defaultChannel;

    public TimezoneServiceGrpc.TimezoneServiceBlockingStub defaultChannelBlockingStub() {
        return TimezoneServiceGrpc.newBlockingStub(defaultChannel);
    }

}
