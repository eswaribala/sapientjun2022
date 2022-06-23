package com.sapient.utility;

import com.sapient.models.Vehicle;

public class DeadLock {
    public static void main(String[] args){

        Vehicle[] vehicles=new Vehicle[2];
        vehicles[0]=new Vehicle();
        vehicles[1]=new Vehicle();

        Thread thread1=new Thread(){
            @Override
            public void run() {
                synchronized (vehicles[0]){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                synchronized (vehicles[1]){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        };
        Thread thread2=new Thread(){
            @Override
            public void run() {
                synchronized (vehicles[0]){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                synchronized (vehicles[1]){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        };

        thread1.start();
        thread2.start();

    }
}
