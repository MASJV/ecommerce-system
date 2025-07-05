package com.example.ecommerce_system.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class Review {
    private static int reviews = 0;
    private final int reviewId;
    private final int productId;
    private final int userId;
    private String productName;
    private String description;
    private Double rating; // need to add condition for rating >=0 and <= 10

    public Review(int productId, int userId, String productName, String description, Double rating) {
        this.reviewId = ++reviews;
        this.productId = productId;
        this.userId = userId;
        this.productName = productName;
        this.description = description;
        this.rating = rating;
    }
    // also limit only 1 review per user(done)
}
