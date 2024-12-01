//package com.app.StudentPracticeApp.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.SecurityBuilder;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
//                .httpBasic(Customizer.withDefaults())
//                .authorizeHttpRequests(authorizeRequest -> authorizeRequest
//                        .requestMatchers("/test/student").hasAuthority("student")
//                        .requestMatchers("/test/admin").hasAuthority("admin"))
//                .anyRequest().permitAll()
//                .formLogin(Customizer.withDefaults());
//        return httpSecurity.build();
//        return http.build();
//    }
//}

