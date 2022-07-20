package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@Component
//@Scope("prototype")
public class Policy {
    private long policyNo;
    private String policyName;
    private LocalDate fromDate;
    private LocalDate toDate;
    private long sumInsured;
    @Autowired
    private Vehicle vehicle;

}
