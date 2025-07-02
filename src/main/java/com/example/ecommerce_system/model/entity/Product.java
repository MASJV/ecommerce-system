package com.example.ecommerce_system.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class Product { // price to be added
    private static int products = 0;
    private final int productId;
    private String name;
    private String description;
    private int quantity;
    private double avgRating;
    private int totalRating;

   public Product(String name, String description, int quantity) {
        this.productId = ++products;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.avgRating = avgRating;
        this.totalRating = totalRating;
    }
//
//    public Product(int productId, String name, String description, int quantity, double avgRating, int totalRating) {
//        this.productId = productId;
//        this.name = name;
//        this.description = description;
//        this.quantity = quantity;
//        this.avgRating = avgRating;
//        this.totalRating = totalRating;
//    }

}
