package com.sapient.facade;

import org.springframework.stereotype.Component;

@Component
public interface DataStore {

    void writeData(String message);
}
