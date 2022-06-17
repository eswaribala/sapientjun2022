package com.ps.models;

import lombok.Data;

import java.time.LocalDate;
@Data
public class FoodItem extends Product{

    private LocalDate dom;
    private LocalDate doe;
    private boolean vegetarian;

}
