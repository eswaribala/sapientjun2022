package com.sapient.globalinsurancesbweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vehicle {

    private long chassisNo;

    private String regNo;

    private String engineNo;

    private String  make;

    private String color;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dor;

    private Owner owner;

}
