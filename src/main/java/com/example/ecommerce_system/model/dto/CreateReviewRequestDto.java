package com.example.ecommerce_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class CreateReviewRequestDto {
    private int productId;
    private int userId;
    private String productName;
    private String description;
    private Double rating;
}

/**
 * {
 *     "productId": 1,
 *     "userId": 1,
 *     "productName": "",
 *     "description": "",
 *     "rating": 9.5
 * }
 */
