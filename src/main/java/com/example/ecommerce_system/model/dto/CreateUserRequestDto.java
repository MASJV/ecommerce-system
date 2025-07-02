package com.example.ecommerce_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class CreateUserRequestDto {
    private String name;
    private int birthYear;
    private String country;
}

/**
 * {
 *    "name": "Jaiveer",
 *    "birthYear": 2007,
 *    "country": "India"
 * }
 */
