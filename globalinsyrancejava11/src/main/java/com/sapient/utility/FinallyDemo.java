package com.sapient.utility;

public class FinallyDemo {

    public static  void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().isDaemon());
/*
        ClaimFacade claimFacade=new ClaimImpl("claims.csv");
        try {
            claimFacade.addClaim(new Claim(485685,34598459,
                    450000,
                    LocalDate.of(2022,2,12)),new Vehicle());
        } catch (IOException e) {

        }


        CovidFacade covidFacade=new CovidImpl();
        try {
            covidFacade.getAllData("country_wise_latest.csv");
        } catch (IOException e) {

        }

 */

    }
}
