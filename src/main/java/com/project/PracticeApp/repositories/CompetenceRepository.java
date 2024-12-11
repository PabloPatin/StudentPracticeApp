package com.project.PracticeApp.repositories;


import com.project.PracticeApp.orm.Competency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetenceRepository extends JpaRepository<Competency, Long> {
    public Optional<Competency> findByName(String name);
}
