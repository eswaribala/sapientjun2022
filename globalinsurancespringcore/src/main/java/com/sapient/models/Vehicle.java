package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private String regNo;
    private String make;
    private String color;
    private long cost;
    private Date dop;
}
