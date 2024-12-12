package com.project.PracticeApp.orm;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GroupPractice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Short year;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "student_group_id", nullable = false)
    private StudentGroup group;

    @ManyToOne
    @JoinColumn(name = "curator_id", nullable = false)
    private Curator curator;

    @OneToMany(mappedBy = "groupPractice", cascade = CascadeType.REMOVE)
    private List<Practice> practices = new ArrayList<>();

    protected GroupPractice() {
    }

    public GroupPractice(StudentGroup group, Curator curator, LocalDate startDate, LocalDate endDate) {
        this.group = group;
        group.addPractice(this);
        this.curator = curator;
        this.startDate = startDate;
        this.endDate = endDate;
        this.year = (short) startDate.getYear();
    }

    public Long getId() {
        return id;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    public Curator getCurator() {
        return curator;
    }

    public void setCurator(Curator curator) {
        this.curator = curator;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Practice> getPractices() {
        return practices;
    }

    public void setPractices(List<Practice> practices) {
        this.practices = practices;
    }

    public void addPractices(Practice practice){
        this.practices.add(practice);
    }

    public String getPeriod(){
        return String.format("%1$te-%2$te %1$tB %1$tY", this.startDate, this.endDate);
    }
}

