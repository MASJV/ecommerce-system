package com.example.ecommerce_system.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor

public class Product { // price to be added
    private static int products = 0;
    private final int productId;
    private String name;
    private String description;
    private int quantity;
    private double avgRating; // why its not a property of Review and of Product
    private int totalRating; // rating cannot be less and 0 and more than 10(ensure it at final stage)!!!!!!
    private final List<Review> reviews;

   public Product(String name, String description, int quantity) {
        this.productId = ++products;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.avgRating = avgRating;
        this.totalRating = totalRating;
       this.reviews = new ArrayList<>();
    }
    public Product(int productId, String name, String description, int quantity, List<Review> reviews) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.avgRating = avgRating;
        this.totalRating = totalRating;
        this.reviews = reviews;
    }


    public void addReview(Review review) {
       reviews.add(review);
       // expression to calculate avgRating
        avgRating = ((avgRating * totalRating) + review.getRating()) / (totalRating + 1);
        totalRating += 1;
    }

    public void deleteReview(Review review) {
       reviews.remove(review);
        // expression to calculate avgRating
        avgRating = ((avgRating * totalRating) - review.getRating()) / (totalRating - 1);
        totalRating -= 1;
    }

    public void updateReview(Review oldReview, Review newReview) {
       deleteReview(oldReview);
       addReview(newReview);
    }

}
