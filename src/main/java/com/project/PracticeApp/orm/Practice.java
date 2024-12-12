package com.project.PracticeApp.orm;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact companyMentor;

    @OneToOne
    private Feedback studentFeedback;

    @OneToMany(mappedBy = "practice")
    private List<PreparationNote> preparationNotes = new ArrayList<>();

    private Boolean hasReport = Boolean.FALSE;
    private String studentPost;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PracticeStatus status = PracticeStatus.UNKNOWN;


    protected Practice() {
    }

    public Practice(Student student, GroupPractice groupPractice) {
        this.student = student;
        this.groupPractice = groupPractice;
    }

    public Practice(Student student, GroupPractice groupPractice, Company company, Contact companyMentor) {
        this.student = student;
        this.groupPractice = groupPractice;
        this.company = company;
        this.companyMentor = companyMentor;
    }

    public Practice(Student student, GroupPractice groupPractice, Company company, Department department, Contact companyMentor) {
        this.student = student;
        this.groupPractice = groupPractice;
        this.company = company;
        this.department = department;
        this.companyMentor = companyMentor;
    }

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

    public Feedback getStudentFeedback() {
        return studentFeedback;
    }

    public void setStudentFeedback(Feedback studentFeedback) {
        this.studentFeedback = studentFeedback;
    }

    public List<PreparationNote> getPreparationNotes() {
        return preparationNotes;
    }

    public void setPreparationNotes(List<PreparationNote> notes) {
        this.preparationNotes = notes;
    }

    public PracticeStatus getStatus() {
        return status;
    }

    public void setStatus(PracticeStatus status) {
        this.status = status;
    }

    public void addNote(PreparationNote note) {
        this.preparationNotes.add(note);
        note.setPractice(this);
    }

}

