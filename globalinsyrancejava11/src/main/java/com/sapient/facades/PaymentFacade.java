package com.sapient.facades;

public interface PaymentFacade {

    default String processPayment(){
        return "done";
    }

}
