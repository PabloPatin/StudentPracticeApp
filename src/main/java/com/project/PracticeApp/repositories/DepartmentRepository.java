package com.project.PracticeApp.repositories;

import com.project.PracticeApp.orm.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Можно добавить кастомные методы
}
