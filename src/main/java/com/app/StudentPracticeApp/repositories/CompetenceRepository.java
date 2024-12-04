package com.app.StudentPracticeApp.repositories;

import com.app.StudentPracticeApp.orm.Competency;
import com.app.StudentPracticeApp.orm.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenceRepository extends JpaRepository<Competency, Long> {
}
