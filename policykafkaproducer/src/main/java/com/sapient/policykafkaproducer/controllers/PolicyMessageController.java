package com.sapient.policykafkaproducer.controllers;

import com.sapient.policykafkaproducer.models.Policy;
import com.sapient.policykafkaproducer.services.PolicyMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/policies")
public class PolicyMessageController {
    @Autowired
    private PolicyMessageService policyMessageService;

    @PostMapping({"/v1.0"})
    public ResponseEntity<?> sendPolicyToKafka(@RequestBody Policy policy){

        if(this.policyMessageService.sendMessage(policy)){
            return ResponseEntity.status(HttpStatus.OK).body("Policy Delivered....");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Policy Not Delivered....");
        }
    }


}
