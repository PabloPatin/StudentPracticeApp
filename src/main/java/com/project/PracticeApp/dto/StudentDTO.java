package com.project.PracticeApp.dto;

import com.project.PracticeApp.orm.Competency;
import com.project.PracticeApp.repositories.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentDTO {
    private String registration;
    private String phone;
    private String email;
    private String comments;
    private String competencies;

    @Autowired
    CompetenceRepository competenceRepository;

    // Конструктор
    public StudentDTO(String registration, String phone, String email, String comments, Set<Competency> competencies) {
        this.registration = registration;
        this.phone = phone;
        this.email = email;
        this.comments = comments;
        this.competencies = joinCompetencies(competencies);
    }

    public String joinCompetencies(Set<Competency> competencies){
        return String.join(", ", competencies.stream().map(Competency::getName).collect(Collectors.toSet()));
    }

    public Set<Competency> parseCompetencies(String competenciesString){
        Set<Competency> competencies = new HashSet<>();
        Set<String> comp = Arrays.stream(competenciesString.split(",")).map(String::strip).collect(Collectors.toSet());
        for (String com : comp) {
            Competency newCompetency = competenceRepository.findByName(com).orElseGet(() -> new Competency(com));
            competencies.add(newCompetency);
        }
        return competencies;
    }

    public String getRegistration() {
        return registration;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getComments() {
        return comments;
    }

    public String getCompetencies() {
        return competencies;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCompetencies(String competencies) {
        this.competencies = competencies;
    }
}
