package com.sapient.claimkafkaconsumerapi.facade;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface PolicyConsumerFacade {
    String inChannel="policy-in";
    @Input(inChannel)
    MessageChannel messageInChannel();
}
