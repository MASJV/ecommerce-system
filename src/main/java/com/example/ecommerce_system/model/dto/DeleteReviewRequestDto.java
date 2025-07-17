package com.example.ecommerce_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// no builder in any dto right!!

public class DeleteReviewRequestDto { // for delete also dto as review is property of entity product!!!
    private int productId; // only reviewId will do the work????!!! gotta navigate so its correct using productId
    // from reviewid the review located and from that the productId should be retrieved. try it
}

/**
 * {
 *     "productId": 1
 * }
 */
