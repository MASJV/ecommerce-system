package com.example.ecommerce_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class AddToCartDto {
    private int productId;
    private int quantity;
}

/**
 * {
 *     "productId": 1,
 *     "quantity": 10
 * }
 */
