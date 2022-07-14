package com.ericsson.utility;

import com.ericsson.models.CarFactory;
import com.ericsson.models.CarType;

public class AbstractDesign  
{ 
    public static void main(String[] args) 
    { 
        System.out.println(CarFactory.buildCar(CarType.MICRO)); 
        System.out.println(CarFactory.buildCar(CarType.MINI)); 
        System.out.println(CarFactory.buildCar(CarType.LUXURY)); 
    } 
} 