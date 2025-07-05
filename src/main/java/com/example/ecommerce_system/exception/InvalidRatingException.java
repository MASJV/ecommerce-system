package com.example.ecommerce_system.exception;

public class InvalidRatingException extends Exception{
    public InvalidRatingException(String message, Throwable reason) {
        super(message, reason);
    }

    public InvalidRatingException(String message) {
        super(message);
    }
}
