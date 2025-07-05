package com.example.ecommerce_system.exception;

public class ReviewAlreadyExistsException extends Exception{
    public ReviewAlreadyExistsException(String message, Throwable reason) {
        super(message, reason);
    }

    public ReviewAlreadyExistsException(String message) {
        super(message);
    }
}
