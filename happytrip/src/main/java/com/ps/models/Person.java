package com.ps.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Parameswari
 * @version 1.0
 * @since 17.06.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private long personId;
    private String name;
    private LocalDate dob;
    private boolean status;
}
