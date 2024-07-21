package com.example.bookstore.dto.user;

public record UserRequestDto(
        String email,
        String password,
        String repeatPassword,
        String firstName,
        String lastName,
        String shippingAddress
) {
}
