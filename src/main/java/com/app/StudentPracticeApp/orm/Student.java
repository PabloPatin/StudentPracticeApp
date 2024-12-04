package com.app.StudentPracticeApp.orm;

import com.app.StudentPracticeApp.services.PasswordService;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "site_user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String fullName;

    private String registration;
    private String skills;

    private String email;
    private String phone;

    private String comments;

    @ManyToOne
    @JoinColumn(name = "competency_id", nullable = false)
    private Competency competency;

    @ManyToOne
    @JoinColumn(name = "student_group_id", nullable = false)
    private StudentGroup group;

    @OneToMany(mappedBy = "student")
    private List<Practice> practices;

    protected Student() {
    }

    public Student(String fullName, StudentGroup group, String login, String password) {
        this.fullName = fullName;
        this.group = group;
        this.login = login;
        this.passwordHash = new PasswordService().encodePassword(password);
    }

    public Student(String fullName, String skills, StudentGroup group, Practice practice, String registration) {
        this.fullName = fullName;
        this.skills = skills;
        this.group = group;
        this.registration = registration;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    public List<Practice> getPractices() {
        return practices;
    }

    public void setPractices(List<Practice> practices) {
        this.practices = practices;
    }

    public void addPractice(Practice practice){
        this.practices.add(practice);
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}

