package com.app.StudentPracticeApp.orm;

import jakarta.persistence.*;

@Entity
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Student student;
    @OneToOne
    private Company company;


    private PracticeStatus practiceStatus;
}
