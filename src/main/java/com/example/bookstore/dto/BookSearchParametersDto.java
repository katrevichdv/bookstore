package com.example.bookstore.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import java.util.List;

public record BookSearchParametersDto(
        List<String> title,
        List<String> author,
        List<String> isbn,
        @Min(0) @Digits(integer = 8, fraction = 2)
        String minPrice,
        @Min(0) @Digits(integer = 8, fraction = 2)
        String maxPrice,
        List<String> description) {
}
