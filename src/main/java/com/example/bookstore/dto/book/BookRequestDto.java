package com.example.bookstore.dto.book;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BookRequestDto(
        @NotBlank
        @Size(max = 255)
        String title,
        @NotBlank
        @Size(max = 255)
        String author,
        @NotBlank
        @Size(max = 255)
        String isbn,
        @Positive @Digits(integer = 8, fraction = 2)
        String price,
        @Size(max = 512)
        String description,
        @Size(max = 512)
        String coverImage) {
}
