package com.sapient.utility;

import com.sapient.Main;
import com.sapient.models.Claim;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class TypeInferenceDemo {
    private static final Logger logger = LoggerFactory.getLogger(TypeInferenceDemo.class);
    public static void main(String[] args){
        //class type inference
        var claim=new Claim(485685,34598459,
                450000,
                LocalDate.of(2022,2,12));
        logger.info(claim.toString());

      //lambda type inference
      var result=  ClaimAppStream.createClaims().stream()
              .filter((@NonNull var x)->x.getClaimDate()
                .isBefore(LocalDate.now()))
              .map((var x)->x.getClaimDate().toString())
                .collect(Collectors.joining(","));
        logger.info(result);

    }
}
