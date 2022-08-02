package com.ps.log4jdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbConfiguration implements CommandLineRunner {

    @Value("${message}")
    private String message;
    @Value("${dburl}")
    private String dburl;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Message property: " + message);
        System.out.println("DB Url property: " + dburl);
    }
}
