package com.example.ecommerce_system.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message, Throwable reason) {
        super(message, reason);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
