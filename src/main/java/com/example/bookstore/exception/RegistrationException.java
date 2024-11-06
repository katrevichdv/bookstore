package com.example.bookstore.exception;

public class RegistrationException extends Exception {
    private RegistrationException(String message) {
        super(message);
    }

    public static RegistrationException emailExist(String email) {
        return new RegistrationException("User with email " + email + ": already exists");
    }
}
