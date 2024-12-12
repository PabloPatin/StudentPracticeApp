package com.project.PracticeApp.services;

import com.project.PracticeApp.orm.User;
import com.project.PracticeApp.repositories.UserRepository;
import com.project.PracticeApp.security.SiteUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SiteUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public SiteUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UserDetails details = new SiteUserDetails(user);
        return details;
    }

    public void saveUser(User user) {
        Optional<User> userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB.isPresent()) {
            User newUser = userFromDB.get();
            newUser.setPasswordHash(user.getPasswordHash());
            newUser.setUsername(user.getUsername());
            newUser.setRole(user.getRole());
            user = newUser;
        }
        userRepository.save(user);
    }
}
