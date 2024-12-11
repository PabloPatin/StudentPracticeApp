package com.project.PracticeApp.orm;

public enum PracticeStatus {
    UNKNOWN("Нет"),
    IN_PROGRESS("В работе"),
    DONE("Взят на практику"),
    FINISHED("Практика зваершена");

    private final String string;
    PracticeStatus(String string){
        this.string = string;
    }

    @Override
    public String toString(){
        return this.string;
    }
}
