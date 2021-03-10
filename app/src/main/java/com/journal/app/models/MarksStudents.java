package com.journal.app.models;

public class MarksStudents {

    private String secondName;
    private String name;
    private String patronymic;
    private String date;
    private String mark;
    private boolean attendance;

    public MarksStudents(String secondName, String name, String patronymic,
                         String date, String mark, boolean attendance) {
        this.secondName = secondName;
        this.name = name;
        this.patronymic = patronymic;
        this.date = date;
        this.mark = mark;
        this.attendance = attendance;
    }

    public MarksStudents() {
    }

    public String getName(){
        return secondName + " " + name + " " + patronymic;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setName(String secondName, String name, String patronymic) {
        this.secondName = secondName;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return patronymic;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }
}
