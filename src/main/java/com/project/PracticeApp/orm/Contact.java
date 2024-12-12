package com.project.PracticeApp.orm;

import jakarta.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;
    private String phone;
    private String post;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    protected Contact() {
    }

    public Contact(String name, Company company) {
        this.name = name;
        this.company = company;
        company.addContact(this);
    }

    public Contact(String name, String email, String phone, Company company) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
        company.addContact(this);
    }

    public Contact(String name, String email, String phone, Department department) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        department.addContact(this);
    }

    public Contact(String name, String email, String phone, String post, Department department) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        department.addContact(this);
        this.post = post;
    }

    public Contact(String name, String email, String phone, String post, Company company) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
        company.addContact(this);
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
