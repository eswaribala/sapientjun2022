package com.sapient.utility;

import com.sapient.facades.ClaimFacade;
import com.sapient.models.Claim;
import com.sapient.models.Vehicle;

import java.time.LocalDate;

public class ClaimApp {

    public static  void main(String[] args){
        //lambda expression
        Claim claim=new Claim(485685,34598459,
                450000,
                LocalDate.of(2022,2,12));

        ClaimFacade claimFacade=(claimObj,vehicleObj)->{
            if(vehicleObj.getModel().startsWith("H"))
              return claimObj.getClaimDate().isBefore(LocalDate.now());
            else
                return false;
        };

        claimFacade.addClaim(claim,new Vehicle("TN-82-1234","Honda"));
    }
}
