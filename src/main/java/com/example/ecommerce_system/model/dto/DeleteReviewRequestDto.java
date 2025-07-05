package com.example.ecommerce_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// no builder in any dto right!!

public class DeleteReviewRequestDto { // for delete also dto as review is property of entity product!!!
    private int productId;
}

/**
 * {
 *     "productId": 1
 * }
 */
