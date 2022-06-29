package com.sapient.utility;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nDemo {
    public static void main(String[] args){
        ResourceBundle rb1 = ResourceBundle
                .getBundle("message");
        System.out.println(rb1.getLocale());
        System.out.println(rb1.getString("greeting"));

        Locale tamilLocale = new Locale("tn", "IN");
        ResourceBundle rb = ResourceBundle
                .getBundle("message", tamilLocale);
        System.out.println(rb.getString("greeting"));


    }
}
