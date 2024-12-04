package com.app.StudentPracticeApp.repositories;

import com.app.StudentPracticeApp.orm.PreparationNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreparationNoteRepository extends JpaRepository<PreparationNote, Long> {
    // Можно добавить кастомные методы
}

