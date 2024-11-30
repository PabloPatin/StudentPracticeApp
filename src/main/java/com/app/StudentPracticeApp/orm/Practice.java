package com.app.StudentPracticeApp.orm;

import jakarta.persistence.*;

import java.time.Year;

@Entity
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "group_practice_id", nullable = false)
    private GroupPractice groupPractice;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact companyMentor;

    @Lob
    private String studentFeedback;

    @Lob
    private String notes;

    protected Practice() {
    }

    public Practice(Student student, GroupPractice groupPractice, Company company, Contact companyMentor) {
        this.student = student;
        this.groupPractice = groupPractice;
        this.company = company;
        this.companyMentor = companyMentor;
    }

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public GroupPractice getGroupPractice() {
        return groupPractice;
    }

    public void setGroupPractice(GroupPractice groupPractice) {
        this.groupPractice = groupPractice;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Contact getCompanyMentor() {
        return companyMentor;
    }

    public void setCompanyMentor(Contact companyMentor) {
        this.companyMentor = companyMentor;
    }

    public String getStudentFeedback() {
        return studentFeedback;
    }

    public void setStudentFeedback(String studentFeedback) {
        this.studentFeedback = studentFeedback;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

