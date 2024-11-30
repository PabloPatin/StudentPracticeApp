package com.app.StudentPracticeApp.orm;

import com.app.StudentPracticeApp.utils.Hasher;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String fullName;

    private String hometown;
    private String skills;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @OneToMany(mappedBy = "student")
    private List<Practice> practices;

    protected Student() {
    }

    public Student(String fullName, Group group, String login, String password) {
        this.fullName = fullName;
        this.group = group;
        this.login = login;
        this.passwordHash = Hasher.hashPassword(password);
    }

    public Student(String fullName, String skills, Group group, Practice practice, String hometown) {
        this.fullName = fullName;
        this.skills = skills;
        this.group = group;
        this.hometown = hometown;
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

