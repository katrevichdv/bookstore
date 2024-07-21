package com.example.bookstore.dto.book;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.List;

public record BookSearchParametersDto(
        List<@Size(max = 255)String> title,
        List<@Size(max = 255)String> author,
        List<@Size(max = 255)String> isbn,
        @Positive @Digits(integer = 8, fraction = 2)
        String minPrice,
        @Positive @Digits(integer = 8, fraction = 2)
        String maxPrice,
        List<@Size(max = 512)String> description) {
}
