package com.project.PracticeApp.repositories;

import com.project.PracticeApp.orm.Practice;
import com.project.PracticeApp.orm.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PracticeRepository extends JpaRepository<Practice, Long> {
    List<Practice> findAllPracticeByStudent(Student student);

    Practice findPracticeById(Long practiceId);
}

