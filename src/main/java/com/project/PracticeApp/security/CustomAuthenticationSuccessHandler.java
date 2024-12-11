package com.project.PracticeApp.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // Получаем роль пользователя
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        // Перенаправляем в зависимости от роли
        if (role.equals(Role.STUDENT.name())) {
            response.sendRedirect("/student/profile");
        } else if (role.equals(Role.CURATOR.name())) {
            response.sendRedirect("/teacher/dashboard");
        } else {
            response.sendRedirect("/");
        }
    }
}
