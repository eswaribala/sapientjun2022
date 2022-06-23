package com.sapient.threads;

import java.util.Random;
import java.util.concurrent.Callable;

public class OTPGenerator implements Callable {
    @Override
    public Object call() throws Exception {
        return new Random().nextInt(100000);
    }
}
