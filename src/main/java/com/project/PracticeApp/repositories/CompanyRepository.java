package com.project.PracticeApp.repositories;


import com.project.PracticeApp.orm.Company;
import com.project.PracticeApp.orm.Competency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    public Optional<Company> findByName(String name);
}

