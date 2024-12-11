package com.project.PracticeApp.controllers;



import com.project.PracticeApp.security.Role;
import com.project.PracticeApp.security.SiteUserDetails;
import com.project.PracticeApp.services.PasswordService;
import com.project.PracticeApp.services.SiteUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class AuthController {
    @Autowired
    private SiteUserDetailService siteUserDetailService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Отображение формы авторизации
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}
