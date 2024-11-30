package com.app.StudentPracticeApp.orm;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    private String hometown;
    private String skills;


    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Practice practice;

    protected Student() {
    }

    public Student(String fullName, Group group) {
        this.fullName = fullName;
        this.group = group;
    }

    public Student(String fullName, Practice practice, Group group) {
        this.fullName = fullName;
        this.practice = practice;
        this.group = group;
    }

    public Student(String fullName, String skills, Group group, Practice practice, String hometown) {
        this.fullName = fullName;
        this.skills = skills;
        this.group = group;
        this.practice = practice;
        this.hometown = hometown;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }
}

