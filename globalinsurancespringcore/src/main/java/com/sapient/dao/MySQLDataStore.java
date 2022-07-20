package com.sapient.dao;

import com.sapient.facade.DataStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MySQLDataStore implements DataStore {
    private static final Logger logger = LoggerFactory.getLogger(MySQLDataStore.class);
    @Override
    public void writeData(String message) {
          logger.info("Message MYSQL Data Store");
    }
}
