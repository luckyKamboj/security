package com.tech.kamboj.controller;

import com.tech.kamboj.common.DozerMapper;
import com.tech.kamboj.component.UserComponent;
import com.tech.kamboj.entities.User;
import com.tech.kamboj.exception.UserNotFoundException;
import com.tech.kamboj.request.UserRequest;
import com.tech.kamboj.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class UserController {

    @Autowired
    UserComponent userComponent;


    @ApiOperation(value = "Create User")
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest user) {
        log.info("Sending user from Client with Values : FirstName: {} , Age: {} , email: {}", user.getUserDto().getUsername(), user.getUserDto().getAge(), user.getUserDto().getEmail());
        User savedUserObject = service.save(DozerMapper.map(user.getUserDto(), User.class));
        return ResponseEntity.ok().body(savedUserObject);
    }

    @ApiOperation(value = "Get List of Users")
    @GetMapping("/user")
    public ResponseEntity<?> findAllUsers() {
        log.info("Getting all Users");
        List<User> list = service.findAllUsers();
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value = "Get User by Id")
    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUsersById(@PathVariable("id") Long id) {
        log.info("Getting User with Id {}", id);
        return service.findUserById(id).map(record -> ResponseEntity.ok().body(record))
                .orElseThrow(() -> new UserNotFoundException("User Searched Not Found", id));
    }


    @ApiOperation(value = "Delete User by Id")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserCode(@PathVariable("id") Long id) {
        log.info("Deleting User with Id {}", id);
        return service.findUserById(id)
                .map(record -> {
                    service.deleteUserById(id);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new UserNotFoundException("User To Delete Not Found", id));
    }

    @ApiOperation(value = "Edit User by ID")
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok().body(userComponent.findUserById(id, userRequest));
    }
}