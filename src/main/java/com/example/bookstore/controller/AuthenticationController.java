package com.example.bookstore.controller;

import com.example.bookstore.dto.user.UserRequestDto;
import com.example.bookstore.dto.user.UserResponseDto;
import com.example.bookstore.exception.RegistrationException;
import com.example.bookstore.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RequiredArgsConstructor
@RestController
public class AuthenticationController {
    private final UserService userService;
    @PostMapping("/registration")
    public UserResponseDto registerUser(@RequestBody @Valid UserRequestDto requestDto)
            throws RegistrationException {
        return userService.register(requestDto);
    }
}
