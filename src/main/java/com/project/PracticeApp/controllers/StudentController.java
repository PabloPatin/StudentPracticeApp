package com.project.PracticeApp.controllers;

import com.project.PracticeApp.dto.StudentDTO;
import com.project.PracticeApp.orm.Competency;
import com.project.PracticeApp.orm.Practice;
import com.project.PracticeApp.orm.Student;
import com.project.PracticeApp.services.PracticeService;
import com.project.PracticeApp.services.SiteUserDetailService;
import com.project.PracticeApp.services.StudentService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private PracticeService practiceService;

    // Страница профиля студента (О себе)
    @GetMapping("/profile")
    public String getProfilePage(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername(); // Получаем имя пользователя
        logger.info(username);
        Student student = studentService.findByUsername(username);
        StudentDTO dto = new StudentDTO(
                student.getRegistration(),
                student.getPhone(),
                student.getEmail(),
                student.getComments(),
                student.getCompetencies()
        );
        model.addAttribute("student", dto); // Передаем объект студента в модель
        return "stud_profile"; // Имя шаблона для страницы "О себе"
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute("student") StudentDTO studentDTO, @AuthenticationPrincipal UserDetails userDetails) {
        logger.info(studentDTO.getCompetencies());
        String username = userDetails.getUsername(); // Получаем имя пользователя
        studentService.updateStudentInfoWithDTO(username, studentDTO);
        return "redirect:/student/profile"; // Перенаправление на страницу профиля
    }
}

