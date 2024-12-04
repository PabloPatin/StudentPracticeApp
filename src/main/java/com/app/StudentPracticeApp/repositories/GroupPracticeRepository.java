package com.app.StudentPracticeApp.repositories;
import com.app.StudentPracticeApp.orm.GroupPractice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupPracticeRepository extends JpaRepository<GroupPractice, Long> {
    // Можно добавить кастомные методы
}
