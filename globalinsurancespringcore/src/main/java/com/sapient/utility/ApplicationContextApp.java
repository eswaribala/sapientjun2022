package com.sapient.utility;

import com.sapient.facade.DataStore;
import com.sapient.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class ApplicationContextApp {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextApp.class);
    public static void main(String[] args){
        ApplicationContext ctx=new ClassPathXmlApplicationContext(
                "spring-annotation-config.xml");
        Vehicle vehicle= (Vehicle) ctx.getBean("vehicle");
        vehicle.setRegNo("TN-02-4567");
        vehicle.setMake("Mercedes");
        vehicle.setColor("black");
        vehicle.setCost(200000000);
        logger.info("Vehicle Info,"+vehicle);
        Policy policy= (Policy) ctx.getBean("policy");
        policy.setPolicyNo(437673);
        policy.setPolicyName("Jeevan Dhara");
        policy.setFromDate(LocalDate.of(2022,2,2));
        policy.setToDate(LocalDate.of(2027,2,2));
        policy.setSumInsured(3465934);
        logger.info("Policy Info,"+policy);
        Claim claim= (Claim) ctx.getBean("claim");
        claim.setClaimId(4356436);

        logger.info("Claim Info,"+claim);

        Refund refund= (Refund) ctx.getBean("refund");
        logger.info("Refund,"+refund);
        //Transaction has data store property
        Transaction transaction= (Transaction) ctx.getBean("transaction");
        logger.info("Transaction,"+transaction);
        transaction.getDataStore().writeData("Tracking....");



    }
}
