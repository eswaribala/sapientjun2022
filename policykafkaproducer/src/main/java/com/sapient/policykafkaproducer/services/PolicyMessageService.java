package com.sapient.policykafkaproducer.services;

import com.sapient.policykafkaproducer.facade.PolicyFacade;
import com.sapient.policykafkaproducer.models.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class PolicyMessageService {
    @Autowired
    private PolicyFacade policyFacade;


    public boolean sendMessage(Policy policy){
        MessageChannel messageChannel= policyFacade.outMessageChannel();

        if(policy.getPolicyNo()==0)
            return false;
        return messageChannel.send(MessageBuilder
                .withPayload(policy)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());


    }


}


