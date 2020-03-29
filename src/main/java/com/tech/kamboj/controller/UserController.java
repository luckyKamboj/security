package com.tech.kamboj.controller;

import com.tech.kamboj.common.BaseResponse;
import com.tech.kamboj.component.UserComponent;
import com.tech.kamboj.request.UserRequest;
import com.tech.kamboj.response.UserResponse;
import com.tech.kamboj.response.UsersInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class UserController {

    @Autowired
    UserComponent userComponent;


    @PostMapping("/user")
    public UserResponse saveUser(@RequestBody @Valid UserRequest user) {
        log.info("Sending user from Client with Values : FirstName: {} , Age: {} , email: {}", user.getUserDto().getUsername(), user.getUserDto().getAge(), user.getUserDto().getEmail());
        return userComponent.save(user.getUserDto());
    }

    @GetMapping("/user")
    public UsersInfoResponse findAllUsers() {
        log.info("Getting all Users");
        return userComponent.findAllUsers();

    }

    @GetMapping("/user/{id}")
    public UserResponse findUsersById(@PathVariable("id") Long id) {
        log.info("Getting User with Id {}", id);
        return userComponent.findUserById(id);
    }


    @DeleteMapping("/user/{id}")
    public BaseResponse deleteUserCode(@PathVariable("id") Long id) {
        log.info("Deleting User with Id {}", id);
        return userComponent.findUser(id);
    }

    @PutMapping("/user/{id}")
    public UserResponse updateUser(@PathVariable("id") Long id, @RequestBody UserRequest userRequest) {
        return userComponent.findUserById(id, userRequest);
    }
}