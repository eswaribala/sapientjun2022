package com.sapient.facades;

import com.sapient.models.Claim;
import com.sapient.models.Vehicle;

import java.util.Random;

@FunctionalInterface
public interface ClaimFacade {

    boolean addClaim(Claim Claim, Vehicle vehicle);

    static long getOTP(){
        return new Random().nextInt(10000);
    }



}
