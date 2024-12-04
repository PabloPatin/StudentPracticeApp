package com.app.StudentPracticeApp.repositories;

import com.app.StudentPracticeApp.orm.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // Можно добавить кастомные методы
}


