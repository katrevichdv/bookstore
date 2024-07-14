package com.example.bookstore.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record BookRequestDto(
        @NotBlank
        String title,
        @NotBlank
        String author,
        @NotBlank
        String isbn,
        @Positive @Digits(integer = 8, fraction = 2)
        String price,
        String description,
        String coverImage) {
}
