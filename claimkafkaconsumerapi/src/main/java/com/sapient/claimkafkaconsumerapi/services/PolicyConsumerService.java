package com.sapient.claimkafkaconsumerapi.services;

import com.sapient.claimkafkaconsumerapi.facade.PolicyConsumerFacade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service

public class PolicyConsumerService {
   @Autowired
    private ProcessMessage processMessage;


    @StreamListener(target = PolicyConsumerFacade.inChannel)


    public void consumeOrder(String message) {

        System.out.println(message);
      processMessage.procesMessage(message);

    }






}
