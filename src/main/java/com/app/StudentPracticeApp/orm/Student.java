package com.app.StudentPracticeApp.orm;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String hometown;
    private String skills;


    @ManyToOne
    private String group;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Practice practice;

}

