package com.sapient.facades;

import com.sapient.models.Claim;
import com.sapient.models.Vehicle;

@FunctionalInterface
public interface ClaimFacade {

    boolean addClaim(Claim Claim, Vehicle vehicle);

}
