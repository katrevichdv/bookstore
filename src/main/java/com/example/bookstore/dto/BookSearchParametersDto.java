package com.example.bookstore.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import java.util.List;

public record BookSearchParametersDto(
        List<String> title,
        List<String> author,
        List<String> isbn,
        @Positive @Digits(integer = 8, fraction = 2)
        String minPrice,
        @Positive @Digits(integer = 8, fraction = 2)
        String maxPrice,
        List<String> description) {
}
