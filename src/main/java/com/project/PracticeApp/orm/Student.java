package com.project.PracticeApp.orm;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String fullName;

    private String registration;
    private String skills;

    private String email;
    private String phone;

    private String comments;

    @ManyToMany
    @JoinTable(
            name = "student_competency",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "competency_id")
    )
    private Set<Competency> competencies = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "student_group_id", nullable = false)
    private StudentGroup group;

    @OneToMany(mappedBy = "student")
    private List<Practice> practices;

    protected Student() {
    }

    public Student(String fullName, User user, StudentGroup group, String email, String phone) {
        this.fullName = fullName;
        this.user = user;
        this.group = group;
        this.email = email;
        this.phone = phone;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void addPractice(Practice practice){
        this.practices.add(practice);
    }

    public void addCompetency(Competency competency){
        this.competencies.add(competency);
        if (!competency.getStudents().contains(this)) {
            competency.addStudent(this);
        }
    }

    public Set<Competency> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(Set<Competency> competencies) {
        this.competencies = competencies;
    }
}

