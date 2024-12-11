package com.project.PracticeApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    @Autowired
    private PasswordEncoder passwordEncoder;


    // Хэширование пароля
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    // Проверка совпадения пароля с хэшом
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}

