package com.tech.kamboj.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long userId;
    private String username;
    private String email;
    private String password;
    private boolean accountNotExpired;
    private boolean credentialNotExpired;
    private boolean active;
    private Integer age;
    private boolean accountNotLocked;
    private boolean enabled;

}
