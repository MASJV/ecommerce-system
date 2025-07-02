package com.example.ecommerce_system.exception;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message, Throwable reason) {
        super(message, reason);
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
