package com.example.ecommerce_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class UpdateProductRequestDto {
    private String name;
    private String description;
    private int quantity;
}

/**
 * {
 *      "name": "All Hair Shampoo",
 *      "description": "great for all types of hair",
 *     "quantity": 20
 * }
 */
