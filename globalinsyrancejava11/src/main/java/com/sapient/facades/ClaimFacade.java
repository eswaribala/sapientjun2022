package com.sapient.facades;

import com.sapient.models.Claim;
import com.sapient.models.Vehicle;

import java.io.IOException;
import java.util.Random;

@FunctionalInterface
public interface ClaimFacade {

    boolean addClaim(Claim claim, Vehicle vehicle) throws IOException;

    static long getOTP(){
        return new Random().nextInt(10000);
    }



}
