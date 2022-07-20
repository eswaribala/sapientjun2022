package com.sapient.models;

import com.sapient.facade.DataStore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private  long transactionId;
    private Policy policy;
    @Autowired
    private DataStore dataStore;

    public Transaction(Policy policy) {
        this.policy = policy;
    }
}
