package com.sapient.models;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Claim.class)
@Data
public class Refund {
    private long refundAmount;

   @Bean("transaction")
   //bean injection
    public Transaction createTransaction(Policy policy){
        return new Transaction(policy);
    }

}
