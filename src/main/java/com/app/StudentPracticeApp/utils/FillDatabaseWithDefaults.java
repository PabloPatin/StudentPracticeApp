package com.app.StudentPracticeApp.utils;

import com.app.StudentPracticeApp.orm.*;
import com.app.StudentPracticeApp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FillDatabaseWithDefaults implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Override
    public void run(String... args) throws Exception {
        // Создание компаний
        Company company1 = new Company("Горные Ресурсы", "Улица Добычи, 1, Магаданская область");
        Company company2 = new Company("ЭнергоМеталл", "Природный проспект, 5, Кемеровская область");
        Department department1 = new Department("Отдел добычи", "Краснодар, улица Пушкина, д.3", company2);
        Department department2 = new Department("IT отдел", "Санкт-Петербург, улица Степана Разина, д.8", company2);
        Contact contact1 = new Contact("Иван Петров", "ivan.petrov@coalpro.com", "+7-913-123-45-67", company1);
        Contact contact2 = new Contact("Мария Иванова", "m.ivanova@enermet.ru", "+7-812-987-65-43", "HR-менеджер", department2);
        companyRepository.save(company1);
        companyRepository.save(company2);

        Faculty faculty1 = new Faculty("ИБИО");
        StudentGroup group1 = new StudentGroup("ИАС-22-1", faculty1, (short) 3);
        StudentGroup group2 = new StudentGroup("ИСТ-21-1", faculty1, (short) 4);
        studentGroupRepository.save(group1);
        studentGroupRepository.save(group2);
    }
}
