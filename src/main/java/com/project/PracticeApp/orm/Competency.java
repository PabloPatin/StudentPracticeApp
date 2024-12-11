package com.project.PracticeApp.orm;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Competency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Номер компетенции

    @Column(nullable = false)
    private String name; // Название компетенции

    @ManyToMany(mappedBy = "competencies")
    private Set<Student> students = new HashSet<>();

    // Конструкторы
    protected Competency() {
    }

    public Competency(String name){
        this.name = name;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Set<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}