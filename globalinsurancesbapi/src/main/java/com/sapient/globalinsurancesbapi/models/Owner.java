package com.sapient.globalinsurancesbapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Owner")
public class Owner {
    @Id
    @Column(name="Mobile_No")
    private long mobileNo;
    @Embedded
    private FullName name;
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
