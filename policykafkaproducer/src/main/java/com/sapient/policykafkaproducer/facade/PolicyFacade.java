package com.sapient.policykafkaproducer.facade;



import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface PolicyFacade {

    String outChannel="policy-out";

    @Output(outChannel)
    MessageChannel outMessageChannel();
}
