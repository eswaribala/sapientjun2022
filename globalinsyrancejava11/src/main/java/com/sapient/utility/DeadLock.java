package com.sapient.utility;

import com.sapient.models.Vehicle;
import com.sapient.threads.VehicleDeadlockSimulationThread;

public class DeadLock {
    public static void main(String[] args){

        Vehicle[] vehicles=new Vehicle[2];
        vehicles[0]=new Vehicle();
        vehicles[1]=new Vehicle();
        VehicleDeadlockSimulationThread[] vehicleDeadlockSimulationThreads=
                new VehicleDeadlockSimulationThread[2];


            vehicleDeadlockSimulationThreads[0]=new
                    VehicleDeadlockSimulationThread(vehicles[0],vehicles[1],"Thread"+0);

        vehicleDeadlockSimulationThreads[1]=new
                VehicleDeadlockSimulationThread(vehicles[1],vehicles[0],"Thread"+1);

    }
}
