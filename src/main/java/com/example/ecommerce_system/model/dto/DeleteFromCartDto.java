package com.example.ecommerce_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class DeleteFromCartDto {
    private int productId;
    private int quantity;
    // also make sure it decrease quantity when deleted quantity and if it hits 0 then product is romoved
    // and also discuss if exception for overdelete request required as in apps u cannot (GUI based)
}

/**
 * {
 *     "productId": 1,
 *     "quantity": 3
 * }
 */
