package com.tech.kamboj.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity(name = "user")
@Data
@Getter
@Setter
public class User {
    public User(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "account_expired", nullable = false)
    private boolean accountNotExpired;

    @Column(name = "credential_expired", nullable = false)
    private boolean credentialNotExpired;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "age")
    private Integer age;

    @Column(name = "accountLocked", nullable = false)
    private boolean accountNotLocked = true;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Override
    public String toString() {
        return "User [user_id=" + userId + ", username=" + username + ", email="
                + email + ", password=" + password + "]";
    }
}
