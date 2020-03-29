package com.tech.kamboj.service;

import com.tech.kamboj.common.DozerMapper;
import com.tech.kamboj.dao.UserRepository;
import com.tech.kamboj.entities.User;
import com.tech.kamboj.exception.UserNotFoundException;
import com.tech.kamboj.request.UserRequest;
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
    public User findUserById(Long id, UserRequest userRequest) {
        User data = DozerMapper.map(userRequest.getUserDto(), User.class);
        return userRepository.findById(id).map(record -> {
            record.setAge(data.getAge());
            record.setActive(data.isActive());
            record.setAccountNotExpired(data.isAccountNotExpired());
            record.setEmail(data.getEmail());
            record.setUsername(data.getUsername());
            record.setUserId(data.getUserId());
            User updated = userRepository.save(record);
            return updated;
        }).orElseThrow(() -> new UserNotFoundException("User not found."));
    }
}
