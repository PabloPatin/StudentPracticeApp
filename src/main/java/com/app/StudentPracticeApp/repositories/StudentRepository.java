package com.app.StudentPracticeApp.repositories;

import com.app.StudentPracticeApp.orm.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Поиск студента по логину
    Optional<Student> findByLogin(String login);
}
