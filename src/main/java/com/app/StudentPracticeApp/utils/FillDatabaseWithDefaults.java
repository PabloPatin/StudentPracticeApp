package com.app.StudentPracticeApp.utils;

import com.app.StudentPracticeApp.repositories.CompetenceRepository;
import com.app.StudentPracticeApp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FillDatabaseWithDefaults {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private C
}
