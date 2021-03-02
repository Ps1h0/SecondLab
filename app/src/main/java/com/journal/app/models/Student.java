package com.journal.app.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group groupId;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }
}
