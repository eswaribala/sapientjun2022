package com.sapient.threads;

import com.sapient.models.Vehicle;

public class VehicleSimulationThread implements Runnable{
    private Vehicle vehicle;

    public VehicleSimulationThread(Vehicle vehicle,String threadName,String regNo) {
        this.vehicle=vehicle;
        this.vehicle.setRegNo(regNo);
        new Thread(this,threadName).start();
    }

    @Override
    public void run() {

        synchronized (vehicle){

            try {

                System.out.print("\n"+Thread.currentThread().getName()+"\t");
                System.out.print(vehicle.getRegNo()+"\t");
                vehicle.sendMessage();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
//rest of the code not synchronized
    }
}
