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
    private String fullName;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
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

    public void addGroup(Group group) {
        this.groups.add(group);
    }
}
