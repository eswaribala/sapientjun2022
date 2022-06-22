package com.sapient.utility;

import com.sapient.models.Owner;
import com.sapient.models.Vehicle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapDemo {

    public static  void main(String[] args){
        List<Owner> cabs=new ArrayList<Owner>();
        Set<Vehicle> vehicles=new HashSet<Vehicle>();
        //first vehicle
        Vehicle vehicle=new Vehicle();
        vehicle.setRegNo("A4258343");
        vehicle.setModel("Honda");
        vehicles.add(vehicle);
        //second vehicle
        vehicle=new Vehicle();
        vehicle.setRegNo("A4258344");
        vehicle.setModel("Mercedes");
        vehicles.add(vehicle);
        Owner owner1=new Owner();
        owner1.setName("Atul");
        owner1.setVehicles(vehicles);
        cabs.add(owner1);
        vehicles=new HashSet<Vehicle>();
        //first vehicle
        vehicle=new Vehicle();
        vehicle.setRegNo("A4258345");
        vehicle.setModel("Honda");
        vehicles.add(vehicle);
        //second vehicle
        vehicle=new Vehicle();
        vehicle.setRegNo("A4258346");
        vehicle.setModel("Lambogini");
        vehicles.add(vehicle);
        Owner owner2=new Owner();
        owner2.setName("Saurav");
        owner2.setVehicles(vehicles);
        cabs.add(owner2);
        List<String> cars = cabs.stream().
                map(d -> d.getVehicles()).
                flatMap(v -> v.stream())
                .map(m->m.getModel()).distinct().
                collect(Collectors.toList());
        System.out.println(cars);


    }

}
