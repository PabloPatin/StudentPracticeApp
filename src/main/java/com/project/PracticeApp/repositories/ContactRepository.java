package com.project.PracticeApp.repositories;

import com.project.PracticeApp.orm.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Можно добавить кастомные методы
}
