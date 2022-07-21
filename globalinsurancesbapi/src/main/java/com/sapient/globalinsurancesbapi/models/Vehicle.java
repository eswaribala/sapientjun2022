package com.sapient.globalinsurancesbapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Chassis_No")
    private long chassisNo;
    @Column(name="Reg_No",length = 15,nullable = false)
    private String regNo;
    @Column(name="Engine_No",length = 25,nullable = false)
    private String engineNo;
    @Column(name="Make",length = 25,nullable = false)
    private String  make;
    @Column(name="Color",length = 15,nullable = false)
    private String color;
    @Column(name="DOR")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dor;

    @ManyToOne
    @JoinColumn(name = "owner_mobile_no",foreignKey = @ForeignKey())
    private Owner owner;

}
