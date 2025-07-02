package com.example.ecommerce_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor // if only generates constructor for final and @NonNull then..... here???

public class UpdateUserRequestDto {
    private String name;
}

/**
 * {
 *     "name": "Jaiveer"
 * }
 */
