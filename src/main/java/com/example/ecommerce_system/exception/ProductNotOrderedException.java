package com.example.ecommerce_system.exception;

public class ProductNotOrderedException extends RuntimeException {
    public ProductNotOrderedException(String message, Throwable reason) {
        super(message, reason);
    }

    public ProductNotOrderedException(String message) {
        super(message);
    }
}
