package com.example.ecommerce_system.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor // had not written then came up user class constructor cannot be applied

public class User {
    private static int users = 0;
    private final int userId;
    private String name;
    private int birthYear; //do it final
    private String country; // do it final
    final private List<Product> cart;
    final private List<Product> order;
    //placeOrderCart -> endpoint for cart ordering
    //placeOrderorder -> endpoint for direct ordering

    public User(String name, int birthYear, String country) {
        this.userId = ++users;
        this.name = name;
        this.birthYear = birthYear;
        this.country = country;
        this.cart = new ArrayList<>();
        this.order = new ArrayList<>();
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

}

