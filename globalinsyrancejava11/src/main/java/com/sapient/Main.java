package com.sapient;

import com.sapient.models.Claim;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static Claim[] createClaims(){
        Claim[] claims=new Claim[3];
        for(int i=0;i<3;i++){
            claims[i]=new Claim();
            claims[i].setClaimId(new Random().nextInt(10000));
            claims[i].setPolicyNo(new Random().nextInt(10000));
            claims[i].setClaimAmount(new Random().nextInt(100000));
            claims[i].setClaimDate(LocalDate.of(2022,1+new Random().nextInt(10),
                    1+new Random().nextInt(26)));
        }
        return claims;
    }
    public static void main(String[] args) {



        System.out.println("Before Sorting....");
        for(Claim claim : createClaims()){
            System.out.println(claim);
        }

        System.out.println("After Sorting by claim date....");
//lambda expression

//interface with anonymous
        Arrays.sort(createClaims(),(o1,o2)->{
            return o1.getClaimDate().compareTo(o2.getClaimDate());
        });
        for(Claim claim : createClaims()){
            System.out.println(claim);
        }

    }
}