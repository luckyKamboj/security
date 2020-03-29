package com.tech.kamboj.config;

import com.tech.kamboj.dao.UserRepository;
import com.tech.kamboj.entities.User;
import com.tech.kamboj.model.CurrentUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("Username or password is incorrect."));
       CurrentUserDetails currentUserDetails = new CurrentUserDetails(user);
       return  currentUserDetails;
    }
}
