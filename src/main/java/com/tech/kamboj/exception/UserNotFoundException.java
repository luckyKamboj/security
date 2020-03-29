package com.tech.kamboj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message, Long id) {
        super(message + ": " +id);
    }
    public UserNotFoundException(String message) {
        super(message);
    }
}
