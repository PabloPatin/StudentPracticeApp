package com.project.PracticeApp.repositories;


import com.project.PracticeApp.orm.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Поиск студента по логину
    @Query("SELECT s FROM Student s WHERE s.user.username = :username")
    Student findByUser_Username(@Param("username")String username);
}
