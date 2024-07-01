package com.example.bookstore.dto;

public record BookResponseDto(
        Long id,
        String title,
        String author,
        String isbn,
        String price,
        String description,
        String coverImage) {
}
