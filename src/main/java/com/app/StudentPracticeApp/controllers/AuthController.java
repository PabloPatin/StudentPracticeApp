package com.app.StudentPracticeApp.controllers;

import com.app.StudentPracticeApp.orm.Student;
import com.app.StudentPracticeApp.repositories.StudentRepository;
import com.app.StudentPracticeApp.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    // Отображение формы авторизации
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordService passwordService;

    // Отображение формы авторизации
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Обработка данных формы
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Находим студента по логину
        if (username.equals("admin")){
            model.addAttribute("message", "Вы успешно вошли в систему!");
            return "redirect:/home";
        }

        Student student = studentRepository.findByLogin(username)
                .orElse(null); // Возвращаем null, если студент не найден

        // Проверка наличия студента и правильности пароля
        if (student != null && passwordService.matches(password, student.getPasswordHash())) {
            model.addAttribute("message", "Вы успешно вошли в систему!");
            return "redirect:/home";  // Перенаправление на домашнюю страницу
        } else {
            model.addAttribute("error", "Неверный логин или пароль");
            return "login";  // Возвращаем на страницу логина с сообщением об ошибке
        }
    }
}
