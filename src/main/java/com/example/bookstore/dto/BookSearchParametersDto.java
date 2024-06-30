package com.example.bookstore.dto;

import java.util.List;

public record BookSearchParametersDto(
        List<String> title,
        List<String> author,
        List<String> isbn,
        String minPrice,
        String maxPrice,
        List<String> description) {
}
