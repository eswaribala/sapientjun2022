package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    private String ownerName;
    private long mobileNo;
    private List<Vehicle> vehicleList;
}
