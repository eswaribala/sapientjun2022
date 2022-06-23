package com.sapient.utility;

import com.sapient.models.Vehicle;
import com.sapient.threads.VehicleSimulationThread;

import java.util.Random;

public class VehicleSimulationApp {

    public static  void main(String[] args){
        Vehicle vehicle=new Vehicle();

        VehicleSimulationThread[] vehicleSimulationThreads=new VehicleSimulationThread[5];
        for(int i=0;i<vehicleSimulationThreads.length;i++){
            vehicleSimulationThreads[i]=new VehicleSimulationThread(vehicle,"Thread"+i,
                    "TN-02-AB"+new Random().nextInt(10000));
        }

    }
}
