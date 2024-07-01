package com.example.bookstore.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record BookRequestDto(
        @NotBlank
        String title,
        @NotBlank
        String author,
        @NotBlank
        String isbn,
        @Min(0) @Digits(integer = 8, fraction = 2)
        String price,
        String description,
        String coverImage) {
}
