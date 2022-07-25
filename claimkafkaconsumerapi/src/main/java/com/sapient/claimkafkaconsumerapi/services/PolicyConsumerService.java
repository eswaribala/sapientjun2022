package com.sapient.claimkafkaconsumerapi.services;

import com.google.gson.Gson;
import com.sapient.claimkafkaconsumerapi.facade.PolicyConsumerFacade;
import com.sapient.claimkafkaconsumerapi.models.Policy;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service

public class PolicyConsumerService {
    private Policy policy;

    @StreamListener(target = PolicyConsumerFacade.inChannel)


    public void consumeOrder(String message) {

        System.out.println(message);
       Gson gson=new Gson();
        policy = gson.fromJson(message, Policy.class);
        System.out.println(policy);
    }


    public Policy getPolicy() {
        return this.policy;
    }



}
