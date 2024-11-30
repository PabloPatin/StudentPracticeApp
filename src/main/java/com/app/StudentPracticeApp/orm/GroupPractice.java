package com.app.StudentPracticeApp.orm;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class GroupPractice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher curator;

    private LocalDate practiceStart;
    private LocalDate practiceEnd;

    @OneToMany(mappedBy = "groupPractice", cascade = CascadeType.ALL)
    private List<Practice> practices = new ArrayList<>();

    protected GroupPractice() {
    }

    public GroupPractice(Group group, Teacher curator, LocalDate practiceStart, LocalDate practiceEnd) {
        this.group = group;
        this.curator = curator;
        this.practiceStart = practiceStart;
        this.practiceEnd = practiceEnd;
    }

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
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

    public List<Practice> getPractices() {
        return practices;
    }

    public void setPractices(List<Practice> practices) {
        this.practices = practices;
    }
}

