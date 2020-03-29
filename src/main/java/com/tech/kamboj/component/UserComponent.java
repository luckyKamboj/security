package com.tech.kamboj.component;

import com.tech.kamboj.dao.UserRepository;
import com.tech.kamboj.request.UserRequest;
import com.tech.kamboj.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    @Autowired
    UserRepository userRepository;

    public UserResponse findUserById(Long id, UserRequest userRequest) {
    }
}
