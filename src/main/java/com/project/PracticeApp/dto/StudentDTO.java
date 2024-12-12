package com.project.PracticeApp.dto;

public class StudentDTO {
    private String name;
    private String registration;
    private String phone;
    private String email;
    private String comments;
    private String competencies;

    public StudentDTO(String registration, String phone, String email, String comments, String competencies) {
        this.registration = registration;
        this.phone = phone;
        this.email = email;
        this.comments = comments;
        this.competencies = competencies;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
