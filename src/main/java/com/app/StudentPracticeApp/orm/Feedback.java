package com.app.StudentPracticeApp.orm;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "practice_id", nullable = false)
    private Practice practice;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Lob
    private String text;

    protected Feedback() {
    }

    public Feedback(Practice practice, String text) {
        this.practice = practice;
        this.text = text;
    }

    public Feedback(Practice practice, Company company, String text) {
        this.practice = practice;
        this.company = company;
        company.addFeedback(this);
        this.text = text;
    }

    public Feedback(Practice practice, Company company, Department department, String text) {
        this.practice = practice;
        this.company = company;
        this.department = department;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}