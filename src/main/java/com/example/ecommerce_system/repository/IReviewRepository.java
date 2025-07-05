package com.example.ecommerce_system.repository;

import com.example.ecommerce_system.exception.ReviewNotFoundException;
import com.example.ecommerce_system.model.entity.Review;

import java.util.List;

public interface IReviewRepository {
    List<Review> getAllReviews();
    Review getAReview(int reviewId) throws ReviewNotFoundException;
    void createAReview(Review review); // void or Review. why not both fine???
    Review updateAReview(int reviewId, String description, Double rating) throws ReviewNotFoundException;
    Review deleteAReview(int reviewId) throws ReviewNotFoundException; // can be done with void also!?!?!?!?!
}
