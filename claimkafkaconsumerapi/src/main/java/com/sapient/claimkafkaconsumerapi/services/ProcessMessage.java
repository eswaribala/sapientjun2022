package com.sapient.claimkafkaconsumerapi.services;

import com.sapient.claimkafkaconsumerapi.facade.MyPolicyRepositoryImpl;

import com.sapient.claimkafkaconsumerapi.models.PSPolicy;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessMessage {
    Logger LOGGER = LoggerFactory.getLogger(ProcessMessage.class);

    @Autowired
    private MyPolicyRepositoryImpl policyImpl;

    public boolean procesMessage(String message)
    {
        LOGGER.info("inside Process Message class");
        boolean flag = false;
        try {
            JSONObject jsonObject = new JSONObject(message);
            PSPolicy policy = new PSPolicy();
            LOGGER.info("jsonObject="+jsonObject);
            LOGGER.info("Policy No...."+(Integer)jsonObject.get("policyNo"));
            policy.setPolicyNo((Integer) jsonObject.get("policyNo"));
            LOGGER.info("Policy Name...."+(String)jsonObject.get("policyName"));
            policy.setPolicyName((String)jsonObject.get("policyName"));
            LOGGER.info("From Date...."+(String)jsonObject.get("fromDate"));
            policy.setFromDate((String)jsonObject.get("fromDate"));
            LOGGER.info("To Date...."+(String)jsonObject.get("toDate"));
            policy.setToDate((String)jsonObject.get("toDate"));
            LOGGER.info("Sum Insured...."+(Integer)jsonObject.get("sumInsured"));
            policy.setSumInsured((Integer)jsonObject.get("sumInsured"));
            LOGGER.info("Policy...."+policy);
            policyImpl.createPolicy(policy);
            flag =  true;
        }catch (Exception e)
        {
            LOGGER.info(e.getMessage());
            flag =  false;
        }
        return  flag;
    }

}
