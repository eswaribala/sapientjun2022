package com.sapient.utility;

import com.sapient.Main;
import com.sapient.facades.ClaimFacade;
import com.sapient.facades.PaymentFacade;
import com.sapient.facades.PaymentImpl;
import com.sapient.facades.TriFunction;
import com.sapient.models.Claim;
import com.sapient.models.Vehicle;

import java.time.LocalDate;
import java.util.function.*;

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

        //inbuilt functional interface
        Function<Claim,Boolean> function=(claimObj)->{
            return claimObj.getClaimId()>1000;
        };
        System.out.println(function.apply(claim));

       //bifunction
        BiFunction<Claim,Claim,Boolean> biFunction=(claim1,claim2)->{
            return claim1.getClaimDate().isBefore(claim2.getClaimDate());
        };
        System.out.println(biFunction.apply(claim,new Claim(2384687,
                4569463,1252345325,
                LocalDate.now().minusMonths(3))));
        //bifunction
        TriFunction<Claim,Claim,Claim,Boolean> triFunction=(claim1, claim2,claim3)->{
            if(claim1.getClaimDate().isBefore(claim2.getClaimDate()))
                return claim3.getClaimId()>claim1.getClaimId();
            else
                return claim3.getClaimId()<claim1.getClaimId();
        };
        System.out.println(triFunction.apply(claim,new Claim(2384687,
                4569463,1252345325,
                LocalDate.now().minusMonths(3)),
                new Claim(2384688,
                        4569466,1252345325,
                        LocalDate.now().minusMonths(4))));

        //consumer accepts the data
        Consumer<Claim[]> consumer=(claims)->{
           for(Claim claimObj : claims){
              System.out.println(claimObj);
           }
        };

        consumer.accept(Main.createClaims());

      //default impl
        PaymentFacade paymentFacade=new PaymentImpl();
        System.out.println(paymentFacade.processPayment());

        //supplier
        //static method ref
        Supplier<Long> supplier= ClaimFacade::getOTP;
        System.out.println(supplier.get());

        Predicate<Claim> predicate=(claimObj)->{
            return claimObj.getClaimId()>0;
        };

         System.out.println( predicate.test(new Claim(-2384687,
                  4569463,1252345325,
                  LocalDate.now().minusMonths(3))));
    }
}
