package com.sapient.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String adharCardNo;
    private String firstName;
    private String lastName;

}
