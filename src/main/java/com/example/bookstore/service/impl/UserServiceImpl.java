package com.example.bookstore.service.impl;

import com.example.bookstore.dto.user.UserRequestDto;
import com.example.bookstore.dto.user.UserResponseDto;
import com.example.bookstore.exception.RegistrationException;
import com.example.bookstore.mapper.UserMapper;
import com.example.bookstore.model.User;
import com.example.bookstore.repository.user.UserRepository;
import com.example.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final String REGISTRATION_EXCEPTION_TEMPLATE =
            "User with email %s: already exists";

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserResponseDto register(UserRequestDto requestDto) throws RegistrationException {
        String email = requestDto.email();
        if (userRepository.existsByEmail(email)) {
            throw new RegistrationException(REGISTRATION_EXCEPTION_TEMPLATE.formatted(email));
        }
        User userToSave = userMapper.toModel(requestDto);
        User savedUser = userRepository.save(userToSave);
        return userMapper.toDto(savedUser);
    }
}
