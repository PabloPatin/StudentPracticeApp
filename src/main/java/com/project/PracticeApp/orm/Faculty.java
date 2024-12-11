package com.project.PracticeApp.orm;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<StudentGroup> studentGroups = new ArrayList<>();

    protected Faculty() {
    }

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGroup(StudentGroup group) {
        this.studentGroups.add(group);
        group.setFaculty(this);
    }
}
