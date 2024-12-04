package com.app.StudentPracticeApp.services;

import com.app.StudentPracticeApp.orm.User;
import com.app.StudentPracticeApp.repositories.UserRepository;
import com.app.StudentPracticeApp.security.SiteUserDetails;
import org.hibernate.annotations.SecondaryRow;
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
        return new SiteUserDetails(user);
    }

    public boolean saveUser(User user) {
        Optional<User> userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB.isPresent()) {
            User newUser = userFromDB.get();
            newUser.setPassword_hash(user.getPassword_hash());
            newUser.setUsername(user.getUsername());
            newUser.setRole(user.getRole());
            user = newUser;
        }
        userRepository.save(user);
        return true;
    }
}
