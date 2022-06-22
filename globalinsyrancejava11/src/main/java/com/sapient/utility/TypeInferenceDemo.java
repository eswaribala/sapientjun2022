package com.sapient.utility;

import com.sapient.models.Claim;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class TypeInferenceDemo {

    public static void main(String[] args){
        //class type inference
        var claim=new Claim(485685,34598459,
                450000,
                LocalDate.of(2022,2,12));
        System.out.println(claim);

      //lambda type inference
      var result=  ClaimAppStream.createClaims().stream()
              .filter((@NonNull var x)->x.getClaimDate()
                .isBefore(LocalDate.now()))
              .map((var x)->x.getClaimDate().toString())
                .collect(Collectors.joining(","));
      System.out.println(result);

    }
}
