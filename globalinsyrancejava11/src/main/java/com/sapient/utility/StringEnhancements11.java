package com.sapient.utility;

import java.util.ResourceBundle;

public class StringEnhancements11 {
public static void main(String[] args){
  //test string in property file

    ResourceBundle resource=ResourceBundle.getBundle("db");
    System.out.println(resource.getString("url"));

}
}
