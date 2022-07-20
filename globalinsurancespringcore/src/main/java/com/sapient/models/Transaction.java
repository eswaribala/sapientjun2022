package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private  long transactionId;
    private Policy policy;

    public Transaction(Policy policy) {
        this.policy = policy;
    }
}
