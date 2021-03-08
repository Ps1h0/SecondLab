package com.journal.app.models;

import javax.persistence.*;

/** Класс, соответствующий таблице "учителя" в базе данных, предназначен для хранения данных
 * @author Nikita Platonov
 */
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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
}
