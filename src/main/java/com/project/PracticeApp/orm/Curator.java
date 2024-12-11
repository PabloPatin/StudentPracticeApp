package com.project.PracticeApp.orm;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Curator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String fullName;

    @OneToMany(mappedBy = "curator")
    private List<GroupPractice> groupPractices = new ArrayList<>();

    protected Curator() {
    }

    public Curator(String fullName, User user) {
        this.fullName = fullName;
        this.user = user;
    }

    public Curator(String fullName, User user, List<GroupPractice> groupPractices) {
        this.fullName = fullName;
        this.user = user;
        this.groupPractices = groupPractices;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<GroupPractice> getGroupPractices() {
        return groupPractices;
    }

    public void setGroupPractices(List<GroupPractice> groupPractices) {
        this.groupPractices = groupPractices;
    }

    public void addGroupPractice(GroupPractice groupPractice) {
        this.groupPractices.add(groupPractice);
    }
}
