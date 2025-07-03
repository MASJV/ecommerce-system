package com.example.ecommerce_system.exception;

public class InsufficientProductQuantityException extends Exception{
    public InsufficientProductQuantityException(String message, Throwable reason) {
        super(message, reason);
    }

    public InsufficientProductQuantityException(String message) {
        super(message);
    }
}
