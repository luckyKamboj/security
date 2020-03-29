package com.tech.kamboj.service;

import com.tech.kamboj.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User request);

    List<User> findAllUsers();

    User findUserById(Long id, User user);

    void deleteUserById(Long id);

    Optional<User> findUserById(Long id);
}
