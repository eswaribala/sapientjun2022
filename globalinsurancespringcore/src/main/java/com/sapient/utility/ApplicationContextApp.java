package com.sapient.utility;

import com.sapient.models.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextApp {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextApp.class);
    public static void main(String[] args){
        ApplicationContext ctx=new ClassPathXmlApplicationContext(
                "spring-annotation-config.xml");

        Vehicle vehicle= (Vehicle) ctx.getBean("vehicle");
        logger.info("Vehile Info,"+vehicle);



    }
}
