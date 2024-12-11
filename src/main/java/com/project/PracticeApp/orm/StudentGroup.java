package com.project.PracticeApp.orm;

import jakarta.persistence.*;
import org.apache.tomcat.util.digester.ArrayStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@Entity
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @Column(nullable = false)
    private Short course;

    @OneToMany(mappedBy = "group")
    private List<GroupPractice> groupPractices = new ArrayList<>();

    @OneToMany(mappedBy = "group")
    private List<Student> students = new ArrayList<>();

    protected StudentGroup() {
    }

    public StudentGroup(String name, Faculty faculty, Short course) {
        this.name = name;
        this.faculty = faculty;
        faculty.addGroup(this);
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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
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
    }

    public void addPractice(GroupPractice groupPractice) {
        this.groupPractices.add(groupPractice);
    }
}

