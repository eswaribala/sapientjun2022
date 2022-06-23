package com.sapient.threads;

import com.sapient.models.Owner;

public class OwnerThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Current thread Id "+Thread.currentThread().getId());
        System.out.println("Current thread Name "+Thread.currentThread().getName());
        System.out.println("Current thread Alive "+Thread.currentThread().isAlive());
        System.out.println("Current thread State "+Thread.currentThread().getState());
        System.out.println("Current thread Priority "+Thread.currentThread().getPriority());
    }
}
