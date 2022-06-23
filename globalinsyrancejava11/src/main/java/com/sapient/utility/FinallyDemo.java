package com.sapient.utility;

import com.sapient.dao.CovidImpl;
import com.sapient.facades.CovidFacade;

import javax.swing.*;
import java.io.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FinallyDemo {

    public static  void main(String[] args) {

        CovidFacade covidFacade=new CovidImpl();
        try {
            covidFacade.getAllData("country_wise_latest.csv");
        } catch (IOException e) {

        }

    }
}
