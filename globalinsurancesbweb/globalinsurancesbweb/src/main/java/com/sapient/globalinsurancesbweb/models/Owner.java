package com.sapient.globalinsurancesbweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Owner {

    private long mobileNo;

    private FullName name;

    private Gender gender;

    private String email;

}
