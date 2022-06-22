package com.sapient.exceptions;
//user defined exception
public class PasswordException extends RuntimeException{

    public PasswordException(String message) {
        super(message);
    }
}
