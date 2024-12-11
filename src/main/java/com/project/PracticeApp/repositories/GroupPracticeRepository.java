package com.project.PracticeApp.repositories;


import com.project.PracticeApp.orm.GroupPractice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupPracticeRepository extends JpaRepository<GroupPractice, Long> {
    // Можно добавить кастомные методы
}
