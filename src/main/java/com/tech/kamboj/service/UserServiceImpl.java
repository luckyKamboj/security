package com.tech.kamboj.service;

import com.tech.kamboj.common.DozerMapper;
import com.tech.kamboj.convertors.Converter;
import com.tech.kamboj.dao.UserRepository;
import com.tech.kamboj.dtos.UserDto;
import com.tech.kamboj.entities.User;
import com.tech.kamboj.exception.UserNotFoundException;
import com.tech.kamboj.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserDto findUserById(Long id, UserDto data) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found."));
        return DozerMapper.map(userRepository.save(Converter.userConverter(data, user)), UserDto.class);

    }
}
