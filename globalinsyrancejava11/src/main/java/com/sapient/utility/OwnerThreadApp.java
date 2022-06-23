package com.sapient.utility;

import com.sapient.threads.OwnerThread;

import java.util.Random;

public class OwnerThreadApp {

    public static void main(String[] args){
        //runnable as parameter to thread
        //multithreading
        Thread[] threads=new Thread[5];
        for(int i=0;i<threads.length;i++) {
            threads[i] = new Thread(new OwnerThread(), "Owner"+i);
            threads[i].setPriority(1+new Random().nextInt(9));
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("All threads done.....");
    }
}
