package com.example.ecommerce_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class CreateProductRequestDto {
    private String name;
    private String description;
    private int quantity;

}

/**
 * {
 *     "name": "Thick Hair Shampoo",
 *     "description": "great for thick hair",
 *     "quantity": 10
 * }
 */
