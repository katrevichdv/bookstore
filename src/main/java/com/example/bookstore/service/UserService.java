package com.example.bookstore.service;

import com.example.bookstore.dto.user.UserRequestDto;
import com.example.bookstore.dto.user.UserResponseDto;
import com.example.bookstore.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRequestDto requestDto) throws RegistrationException;
}
