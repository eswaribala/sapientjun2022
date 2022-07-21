package com.sapient.globalinsurancesbweb.exceptions;

public class RecordFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public RecordFoundException(String message) {
        super(message);
    }
}
