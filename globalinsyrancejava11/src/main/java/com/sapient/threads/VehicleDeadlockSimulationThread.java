package com.sapient.threads;

import com.sapient.models.Vehicle;

public class VehicleDeadlockSimulationThread implements Runnable{
    private Vehicle vehicle1,vehicle2;
    private String regNo;

    public VehicleDeadlockSimulationThread(Vehicle vehicle1,Vehicle vehicle2,
                                           String threadName) {

        this.vehicle1=vehicle1;
        this.vehicle2=vehicle2;
        this.regNo=regNo;
        new Thread(this,threadName).start();
    }

    @Override
    public void run() {

        synchronized (this.vehicle1) {

            try {

                System.out.print("\n" + Thread.currentThread().getName() + "\t");
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this.vehicle2) {

                try {

                    System.out.print("\n" + Thread.currentThread().getName() + "\t");
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
//rest of the code not synchronized
        }
    }

}
