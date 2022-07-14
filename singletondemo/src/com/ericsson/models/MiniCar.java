package com.ericsson.models;

public class MiniCar extends Car 
{ 
    MiniCar(Location location) 
    { 
        super(CarType.MINI,location ); 
        construct(); 
    } 
      
    @Override
    void construct() 
    { 
        System.out.println("Connecting to Mini car"); 
    } 
} 