package com.tech.kamboj.service;

import com.tech.kamboj.dtos.UserDto;
import com.tech.kamboj.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User request);

    List<User> findAllUsers();

    UserDto findUserById(Long id, UserDto user);

    void deleteUserById(Long id);

    Optional<User> findUserById(Long id);
}
