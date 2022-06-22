package com.sapient.utility;

import javax.swing.*;
import java.io.File;
import java.util.ResourceBundle;

public class FinallyDemo {

    public static  void main(String[] args){
        ResourceBundle resourceBundle=ResourceBundle.getBundle("db");
        String location=resourceBundle.getString("location");
        File file=new File(location,"country_wise_latest.csv");
        if(file.exists()){
            System.out.println("File Exists");
        }
        else
            System.out.println("File Not found...");
    }
}
