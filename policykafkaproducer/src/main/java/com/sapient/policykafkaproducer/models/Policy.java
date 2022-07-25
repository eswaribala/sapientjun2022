package com.sapient.policykafkaproducer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

    private long policyNo;
    private String policyName;
    private LocalDate fromDate;
    private LocalDate toDate;
    private long sumInsured;

}
