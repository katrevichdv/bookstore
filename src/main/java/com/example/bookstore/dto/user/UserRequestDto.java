package com.example.bookstore.dto.user;

import com.example.bookstore.validation.constraints.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@FieldMatch(field = "password", fieldMatch = "repeatPassword", message = "Passwords don't match")
public record UserRequestDto(
        @Email
        @NotBlank
        String email,
        @NotBlank
        @Size(min = 8)
        String password,
        @NotBlank
        @Size(min = 8)
        String repeatPassword,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        String shippingAddress) {
}
