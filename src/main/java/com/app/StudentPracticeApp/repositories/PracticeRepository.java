package com.app.StudentPracticeApp.repositories;
import com.app.StudentPracticeApp.orm.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeRepository extends JpaRepository<Practice, Long> {
    // Можно добавить кастомные методы
}

