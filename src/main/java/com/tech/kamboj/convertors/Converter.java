package com.tech.kamboj.convertors;

import com.tech.kamboj.dtos.UserDto;
import com.tech.kamboj.entities.User;

public class Converter {
    private Converter() {
    }

    public static User userConverter(UserDto data, User user) {
        user.setUserId(data.getUserId());
        user.setAge(data.getAge());
        user.setActive(data.isActive());
        user.setAccountNotExpired(data.isAccountNotExpired());
        user.setEmail(data.getEmail());
        user.setUsername(data.getUsername());
        user.setUserId(data.getUserId());
        return user;
    }

}
