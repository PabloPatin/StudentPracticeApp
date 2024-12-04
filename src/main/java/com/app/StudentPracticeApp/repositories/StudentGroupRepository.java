package com.app.StudentPracticeApp.repositories;

import com.app.StudentPracticeApp.orm.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {
}
