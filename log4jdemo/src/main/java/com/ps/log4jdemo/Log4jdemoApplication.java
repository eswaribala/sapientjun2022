package com.ps.log4jdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@SpringBootApplication
public class Log4jdemoApplication {
    private static final Logger LOGGER = LogManager.getLogger(Log4jdemoApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(Log4jdemoApplication.class, args);
        LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");
    }

}
