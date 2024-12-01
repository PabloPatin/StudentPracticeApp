package com.app.StudentPracticeApp.orm;

import jakarta.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    protected Contact() {
    }

    public Contact(String fullName, Company company) {
        this.fullName = fullName;
        this.company = company;
    }


    public Contact(String fullName, String email, String phone, Company company) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }

    public Contact(String fullName, String email, String phone, Company company, Department department) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
