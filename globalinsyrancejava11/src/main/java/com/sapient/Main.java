package com.sapient;

import com.sapient.models.Claim;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static Claim[] createClaims(){
        Claim[] claims=new Claim[3];
        for(int i=0;i<3;i++){
            claims[i]=new Claim();
            claims[i].setClaimId(getRandomNo(10000));
            claims[i].setPolicyNo(getRandomNo(10000));
            claims[i].setClaimAmount(getRandomNo(10000));
            claims[i].setClaimDate(LocalDate.of(2022,1+getRandomNo(10),
                    1+getRandomNo(26)));
        }
        return claims;
    }

    private static int getRandomNo(int number) {
        return new Random().nextInt(number);
    }

    public static void main(String[] args) {



        logger.info("Before Sorting....");
        for(Claim claim : createClaims()){
            logger.info(claim.toString());
        }

        logger.info("After Sorting by claim date....");
//lambda expression

//interface with anonymous
        Arrays.sort(createClaims(),(o1,o2)->{
            return o1.getClaimDate().compareTo(o2.getClaimDate());
        });
        for(Claim claim : createClaims()){
            logger.info(claim.toString());
        }

    }
}