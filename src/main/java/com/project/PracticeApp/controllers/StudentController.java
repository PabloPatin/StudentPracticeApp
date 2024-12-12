package com.project.PracticeApp.controllers;

import com.project.PracticeApp.dto.PracticeDTO;
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
                studentService.joinCompetencies(student.getCompetencies())
        );
        dto.setName(student.getFullName());
        model.addAttribute("student", dto); // Передаем объект студента в модель
        return "stud_profile"; // Имя шаблона для страницы "О себе"
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute("student") StudentDTO studentDTO, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername(); // Получаем имя пользователя
        studentService.updateStudentInfoWithDTO(username, studentDTO);
        return "redirect:/student/profile"; // Перенаправление на страницу профиля
    }

    @GetMapping("/practice")
    public String getPracticePage(Model model, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername(); // Получаем имя пользователя
        Student student = studentService.findByUsername(username);
        Practice practice = student.getPractices().getLast();
        PracticeDTO dto = null;
        if (practice.getCompany() != null){
            if (practice.getCompanyMentor() != null){
                dto = new PracticeDTO(
                        practice.getGroupPractice().getCurator().getFullName(),
                        practice.getGroupPractice().getPeriod(),
                        practice.getStatus(),
                        practice.getCompany().getName(),
                        practice.getCompany().getAddress(),
                        practice.getCompanyMentor().getName(),
                        practice.getCompanyMentor().getPhone(),
                        practice.getCompanyMentor().getEmail()
                );
            } else {
                dto = new PracticeDTO(
                        practice.getGroupPractice().getCurator().getFullName(),
                        practice.getGroupPractice().getPeriod(),
                        practice.getStatus(),
                        practice.getCompany().getName(),
                        practice.getCompany().getAddress(),
                        null,
                        null,
                        null);
            }

        } else {
            dto = new PracticeDTO(
                    practice.getGroupPractice().getCurator().getFullName(),
                    practice.getGroupPractice().getPeriod(),
                    practice.getStatus(),
                    null,
                    null,
                    null,
                    null,
                    null
            );
        }
        model.addAttribute("practice", dto); // Передаем объект студента в модель
        return "stud_practice"; // Имя шаблона для страницы "О себе"
    }

    @PostMapping("/practice")
    public String updatePractice(@ModelAttribute PracticeDTO practiceDTO, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        Student student = studentService.findByUsername(username);
        Practice practice = student.getPractices().getLast();
        practiceService.updatePracticeWithDTO(practice, practiceDTO);
        return "redirect:/student/practice";
    }
}

