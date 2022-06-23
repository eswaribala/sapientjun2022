package com.sapient.utility;

import com.sapient.threads.OTPGenerator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {
public static void main(String[] args){
    ExecutorService executorService= Executors
            .newFixedThreadPool(2);
    //task assigned
    Future future=executorService.submit(new OTPGenerator());

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    executorService.shutdown();

}
}
