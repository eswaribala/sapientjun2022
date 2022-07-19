package com.sapient.globalinsurancejerseyapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
