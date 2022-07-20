package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Policy {
    private long policyNo;
    private String policyName;
    private Date fromDate;
    private Date toDate;
    private long sumInsured;
    @Autowired
    private Vehicle vehicle;

}
