package com.sapient.facades;

import com.sapient.models.Claim;
import com.sapient.models.Vehicle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;


public interface ClaimFacade {

   default boolean addClaim(Claim claim, Vehicle vehicle) throws IOException{
       return false;
   }
    default boolean addClaim(Claim claim) {
        return false;
    }
    default boolean addPostgresClaim(Claim claim) throws SQLException {
        return false;
    }
    static long getOTP(){
        return new Random().nextInt(10000);
    }

   default boolean updateClaim(long claimId,long claimAmount){
       return false;
   }

   default List<Object> getAllClaims(){
       return null;
   }

   default boolean deleteClaimById(long claimId){
       return false;
   }

   default Object getClaimById(long claimId){
       return null;
   }
}
