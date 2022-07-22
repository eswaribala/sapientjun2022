package com.sapient.globalinsurancesbapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//value object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullName {
    @Column(name="First_Name",length = 50,nullable = false)
    private String firstName;
    @Column(name="Middle_Name",length = 50,nullable = true)
    private String middleName;
    @Column(name="Last_Name",length = 50,nullable = false)
    private String lastName;
}
