package com.example.ecommerce_system.repository;

import com.example.ecommerce_system.exception.ReviewNotFoundException;
import com.example.ecommerce_system.model.entity.Review;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository

public class ReviewRepository implements IReviewRepository{
    private List<Review> reviewList;

    public ReviewRepository() { reviewList = new LinkedList<>(); } // ??if not written then @NoArgs?? or we are overriding

    @Override
    public List<Review> getAllReviews() {
        return reviewList;
    }

    @Override
    public Review getAReview(int reviewId) throws ReviewNotFoundException {
        for(Review review : reviewList) {
            if(review.getReviewId() == reviewId) {
                return review;
            }
        }
        throw new ReviewNotFoundException("Review Not Found");
    }

    @Override
    public void createAReview(Review review) {
        reviewList.add(review);
    }

    @Override
    public Review updateAReview(int reviewId, String description, Double rating) throws ReviewNotFoundException {
        for(Review review : reviewList) {
            if(review.getReviewId() == reviewId) {
                review.setDescription(description);
                review.setRating(rating);
                return review;
            }
        }
        throw new ReviewNotFoundException("Review Not Found");
    }

    @Override
    public Review deleteAReview(int reviewId) throws ReviewNotFoundException {
        for(Review review : reviewList) {
            if(review.getReviewId() == reviewId) {
                reviewList.remove(review);
                return review;
            }
        }
        throw new ReviewNotFoundException("Review Not Found");
    }

}
