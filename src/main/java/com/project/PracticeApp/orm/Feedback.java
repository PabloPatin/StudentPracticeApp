package com.project.PracticeApp.orm;

import jakarta.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "practice_id", nullable = false)
    private Practice practice;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private String companyRequirements;
    private Boolean isPaid;
    private String professionDemand;
    private String courseWorkProfit;
    private String practiceReview;
    private String jobOffer;
    private Boolean wantRepeat;
    private Boolean canRepeat;

    protected Feedback() {
    }

    public Feedback(Practice practice) {
        this.practice = practice;
    }

    public Feedback(Practice practice, Company company) {
        this.practice = practice;
        this.company = company;
        company.addFeedback(this);
    }

    public Feedback(Practice practice, Company company, Department department) {
        this.practice = practice;
        this.company = company;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
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