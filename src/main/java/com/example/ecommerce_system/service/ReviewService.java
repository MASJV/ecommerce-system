package com.example.ecommerce_system.service;

import com.example.ecommerce_system.exception.ProductNotFoundException;
import com.example.ecommerce_system.exception.ReviewAlreadyExistsException;
import com.example.ecommerce_system.exception.ReviewNotFoundException;
import com.example.ecommerce_system.model.dto.CreateReviewRequestDto;
import com.example.ecommerce_system.model.dto.DeleteReviewRequestDto;
import com.example.ecommerce_system.model.dto.UpdateReviewRequestDto;
import com.example.ecommerce_system.model.entity.Product;
import com.example.ecommerce_system.model.entity.Review;
import com.example.ecommerce_system.repository.ProductRepository;
import com.example.ecommerce_system.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.getAllReviews();
    }

    public Review getAReview(int reviewId) throws ReviewNotFoundException{
        return reviewRepository.getAReview(reviewId);
    }

    public Review createAReview(final CreateReviewRequestDto createReviewRequestDto) throws ProductNotFoundException, ReviewAlreadyExistsException {
        final List<Review> list = reviewRepository.getAllReviews();
        for(Review review : list) {
            if(review.getUserId() == createReviewRequestDto.getUserId() && review.getProductId() == createReviewRequestDto.getProductId()) {
                throw new ReviewAlreadyExistsException("Review already exists");
            }
        }

        final Review review = new Review(createReviewRequestDto.getProductId(), createReviewRequestDto.getUserId(),
                createReviewRequestDto.getProductName(), createReviewRequestDto.getDescription(),
                createReviewRequestDto.getRating());
        reviewRepository.createAReview(review);

        final Product product = productRepository.getAProduct(createReviewRequestDto.getProductId());
        product.addReview(review);

        return review;
    }

    public Review updateAReview(int reviewId, final UpdateReviewRequestDto updateReviewRequestDto) throws ReviewNotFoundException{
        return reviewRepository.updateAReview(reviewId, updateReviewRequestDto.getDescription(),
                updateReviewRequestDto.getRating());
    }

    public Review deleteAReview(int reviewId, final DeleteReviewRequestDto deleteReviewRequestDto) throws ReviewNotFoundException, ProductNotFoundException {
        final Product product = productRepository.getAProduct(deleteReviewRequestDto.getProductId());
        product.deleteReview(reviewRepository.getAReview(reviewId));
        return reviewRepository.deleteAReview(reviewId);
    }
}
