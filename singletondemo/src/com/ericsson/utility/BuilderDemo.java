package com.ericsson.utility;

import com.ericsson.models.HawaiianPizzaBuilder;
import com.ericsson.models.Pizza;
import com.ericsson.models.PizzaBuilder;
import com.ericsson.models.SpicyPizzaBuilder;
import com.ericsson.models.Waiter;

public class BuilderDemo {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder( hawaiianPizzabuilder );
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
    }
}
