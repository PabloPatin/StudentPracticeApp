package com.app.StudentPracticeApp.repositories;

import com.app.StudentPracticeApp.orm.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Можно добавить кастомные методы
}
