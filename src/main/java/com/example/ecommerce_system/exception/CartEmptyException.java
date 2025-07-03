package com.example.ecommerce_system.exception;

public class CartEmptyException extends Exception{
    public CartEmptyException(String message, Throwable reason) {
        super(message, reason);
    }

    public CartEmptyException(String message){
        super(message);
    }
}
