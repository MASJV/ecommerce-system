package com.example.ecommerce_system.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class UpdateReviewRequestDto {
    private String description;
    private Double rating;
}
