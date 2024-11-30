package com.app.StudentPracticeApp.orm;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class PreparationNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String note;

    @ManyToOne
    @JoinColumn(name = "practice_id", nullable = false)
    private Practice practice;

    protected PreparationNote() {
    }

    public PreparationNote(LocalDate noteDate, String note, Practice practice) {
        this.date = noteDate;
        this.note = note;
        this.practice = practice;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setNoteDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }
}
