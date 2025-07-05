package com.example.ecommerce_system.controller;

import com.example.ecommerce_system.exception.ReviewNotFoundException;
import com.example.ecommerce_system.model.dto.CreateReviewRequestDto;
import com.example.ecommerce_system.model.dto.DeleteReviewRequestDto;
import com.example.ecommerce_system.model.dto.UpdateProductRequestDto;
import com.example.ecommerce_system.model.dto.UpdateReviewRequestDto;
import com.example.ecommerce_system.model.entity.Review;
import com.example.ecommerce_system.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@Slf4j
@RequiredArgsConstructor

public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        log.info("recevied a request to get all reviews");
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getAReview(@PathVariable("reviewId") int reviewId) {
        log.info("recevied a request to get review with id {}", reviewId);
        try {
            Review review = reviewService.getAReview(reviewId);
            return ResponseEntity.ok(review);
        } catch (ReviewNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Review> createAReview(@RequestBody CreateReviewRequestDto createReviewRequestDto){
        log.info("recevied a request to create a review with body {}", createReviewRequestDto);
        try {
            Review review = reviewService.createAReview(createReviewRequestDto);
            return ResponseEntity.ok(review);
        } catch (Exception ex) { // is this perfect, changes in userController as well then. no Review ex one only general
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{reviewId}")
    public ResponseEntity<Review> updateAReview(@PathVariable("reviewId") int reviewId,
                                                @RequestBody UpdateReviewRequestDto updateReviewRequestDto) {
        log.info("recevied a request to update review with id {}", reviewId); // body??
        try {
            Review review = reviewService.updateAReview(reviewId, updateReviewRequestDto);
            return ResponseEntity.ok(review);
        } catch (ReviewNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Review> deleteAReview(@PathVariable("reviewId") int reviewId,
                                                @RequestBody DeleteReviewRequestDto deleteReviewRequestDto) {
        log.info("recevied a request to delete review with id {}", reviewId);
        try {
            Review review = reviewService.deleteAReview(reviewId, deleteReviewRequestDto);
            return ResponseEntity.ok(review);
        } catch (ReviewNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

}
