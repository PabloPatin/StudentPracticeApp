package com.project.PracticeApp.repositories;

import com.project.PracticeApp.orm.Curator;
import com.project.PracticeApp.orm.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CuratorRepository extends JpaRepository<Curator, Long> {
    @Query("SELECT c FROM Curator c WHERE c.user.username = :username")
    Curator findByUser_Username(@Param("username")String username);
}

