package com.project.PracticeApp.repositories;

import com.project.PracticeApp.orm.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // Можно добавить кастомные методы
}


