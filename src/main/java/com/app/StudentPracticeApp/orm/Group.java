package com.app.StudentPracticeApp.orm;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String faculty;

    @Column(nullable = false)
    private Short course;

    @OneToMany(mappedBy = "group")
    private List<GroupPractice> groupPractices = new ArrayList<>();

    @OneToMany(mappedBy = "group")
    private List<Student> students = new ArrayList<>();

    protected Group() {
    }

    public Group(String name, String faculty, Short course) {
        this.name = name;
        this.faculty = faculty;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Short getCourse() {
        return course;
    }

    public void setCourse(Short course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
        student.setGroup(this);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public List<GroupPractice> getGroupPractices() {
        return groupPractices;
    }

    public void setGroupPractices(List<GroupPractice> groupPractices) {
        this.groupPractices = groupPractices;
    }}

