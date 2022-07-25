package com.sapient.claimkafkaconsumerapi.models;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

    private long policyNo;
    private String policyName;
    private String fromDate;
    private String toDate;
    private long sumInsured;
}
