package com.app.StudentPracticeApp.orm;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Competency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Номер компетенции

    @Column(nullable = false)
    private String name; // Название компетенции

    @OneToMany(mappedBy = "competency", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    // Конструкторы
    protected Competency() {
    }
}