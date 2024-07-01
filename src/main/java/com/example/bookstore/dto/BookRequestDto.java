package com.example.bookstore.dto;

public record BookRequestDto(
        String title,
        String author,
        String isbn,
        String price,
        String description,
        String coverImage) {

}
