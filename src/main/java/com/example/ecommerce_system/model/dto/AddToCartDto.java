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
    // if multiple endpoints of add to cart are hit then multiple same products are added
    // rather than only quantity increment(make sure it does not exceed the actual quanity)
    // in order for this to happen make sure the product is there in cart then increment in quantity
    // otherwise add
}

/**
 * {
 *     "productId": 1,
 *     "quantity": 10
 * }
 */
