package com.app.StudentPracticeApp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.StudentPracticeApp.orm.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}

