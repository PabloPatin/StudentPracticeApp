package com.project.PracticeApp.utils;


import com.project.PracticeApp.orm.*;
import com.project.PracticeApp.repositories.*;
import com.project.PracticeApp.security.Role;
import com.project.PracticeApp.services.PasswordService;
import com.project.PracticeApp.services.SiteUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FillDatabaseWithDefaults implements CommandLineRunner {
    @Autowired
    private PasswordService passwordService;

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

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CuratorRepository curatorRepository;

    @Autowired
    private GroupPracticeRepository groupPracticeRepository;

    @Autowired
    private PracticeRepository practiceRepository;

    @Autowired
    private SiteUserDetailService siteUserDetailService;

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

        User curatorUser = new User("teacher", passwordService.encodePassword("teacher"), Role.CURATOR);
        siteUserDetailService.saveUser(curatorUser);
        Curator teacher = new Curator("Иванов И.И.", curatorUser);
        curatorRepository.save(teacher);

        StudentGroup group1 = new StudentGroup("ИАС-22-1", faculty1, (short) 3);
        StudentGroup group2 = new StudentGroup("ИСТ-21-1", faculty1, (short) 4);

        facultyRepository.save(faculty1);
        studentGroupRepository.save(group1);
        studentGroupRepository.save(group2);

        Competency competency1 = new Competency("Java разработка");
        Competency competency2 = new Competency("Веб-разработка");
        competenceRepository.save(competency1);
        competenceRepository.save(competency2);

        User studentUser1 = new User("stud1", passwordService.encodePassword("11111"), Role.STUDENT);
        User studentUser2 = new User("stud2", passwordService.encodePassword("22222"), Role.STUDENT);
        User studentUser3 = new User("stud3", passwordService.encodePassword("33333"), Role.STUDENT);
        siteUserDetailService.saveUser(studentUser1);
        siteUserDetailService.saveUser(studentUser2);
        siteUserDetailService.saveUser(studentUser3);

        Student student1 = new Student("Иванов Иван Петрович", studentUser1, group1, "ivanov@example.com", "+7-912-123-45-67");
        Student student2 = new Student("Петров Пётр Сидорович", studentUser2, group1, "petrov@example.com", "+7-913-987-65-43");
        Student student3 = new Student("Сергеев Сергей Сергеевич", studentUser3, group2, "sergeev@example.com", "+7-914-765-43-21");
        student3.setComments("Целевик");
        student1.addCompetency(competency1);
        student1.addCompetency(competency2);
        student2.addCompetency(competency2);
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        GroupPractice practice1 = new GroupPractice(group1, teacher, LocalDate.of(2025, 6, 9), LocalDate.of(2025, 7, 20));
        GroupPractice practice2 = new GroupPractice(group2, teacher, LocalDate.of(2025, 6, 9), LocalDate.of(2025, 7, 20));
        groupPracticeRepository.save(practice1);
        groupPracticeRepository.save(practice2);

        Practice studentPractice1 = new Practice(student1, student1.getGroup().getGroupPractices().getLast());
        Practice studentPractice2 = new Practice(student2, student2.getGroup().getGroupPractices().getLast(), company2, department2, contact2);
        studentPractice2.setStatus(PracticeStatus.IN_PROGRESS);
        Practice studentPractice3 = new Practice(student2, student2.getGroup().getGroupPractices().getLast(), company1, contact1);
        studentPractice3.setStatus(PracticeStatus.DONE);
        PreparationNote note = new PreparationNote(LocalDate.now(), "Студент взят на практику");
        studentPractice3.addNote(note);
        practiceRepository.save(studentPractice1);
        practiceRepository.save(studentPractice2);
        practiceRepository.save(studentPractice3);
    }
}
