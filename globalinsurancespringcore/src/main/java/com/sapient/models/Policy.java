package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {
    private long policyNo;
    private String policyName;
    private Date fromDate;
    private Date toDate;
    private long sumInsured;
    @Autowired
    private Vehicle vehicle;

}
