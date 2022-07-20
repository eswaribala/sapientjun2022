package com.sapient.dao;

import com.sapient.facade.DataStore;
import com.sapient.utility.ApplicationContextApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OracleDataStore implements DataStore {
    private static final Logger logger = LoggerFactory.getLogger(OracleDataStore.class);
    @Override
    public void writeData(String message) {
       logger.info("Message from Oracle Data Store....");
    }
}
