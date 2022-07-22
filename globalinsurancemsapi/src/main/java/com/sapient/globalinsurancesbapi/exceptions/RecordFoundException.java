package com.sapient.globalinsurancesbapi.exceptions;

public class RecordFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public RecordFoundException(String message) {
        super(message);
    }
}
