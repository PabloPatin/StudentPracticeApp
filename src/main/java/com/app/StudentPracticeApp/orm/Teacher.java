package com.app.StudentPracticeApp.orm;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fullName;

    @OneToMany(mappedBy = "curator", cascade = CascadeType.ALL)
    private List<Group> groups = new ArrayList<>();

    protected Teacher() {
    }

    public Teacher(String fullName) {
        this.fullName = fullName;
    }

    public Teacher(String fullName, List<Group> groups) {
        this.fullName = fullName;
        this.groups = groups;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }
}
