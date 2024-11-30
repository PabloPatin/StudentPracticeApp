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

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String faculty;
    @Column(nullable = false)
    private Short course;

    @ManyToOne
    @JoinColumn(name = "teacher_groups", nullable = false)
    private Teacher curator;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    protected Group() {
    }

    public Group(String name, String faculty, Short course, Teacher curator) {
        this.name = name;
        this.faculty = faculty;
        this.course = course;
        this.curator = curator;
    }

    public Group(String name, String faculty, Short course, LocalDate practiceStart, LocalDate practiceEnd, Teacher curator) {
        this.name = name;
        this.faculty = faculty;
        this.course = course;
        this.practiceStart = practiceStart;
        this.practiceEnd = practiceEnd;
        this.curator = curator;
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

    public LocalDate getPracticeStart() {
        return practiceStart;
    }

    public void setPracticeStart(LocalDate practiceStart) {
        this.practiceStart = practiceStart;
    }

    public LocalDate getPracticeEnd() {
        return practiceEnd;
    }

    public void setPracticeEnd(LocalDate practiceEnd) {
        this.practiceEnd = practiceEnd;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
        curator.addGroup(this);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
