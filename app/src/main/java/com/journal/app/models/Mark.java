package com.journal.app.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mark_id")
    private Long markId;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student studentId;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lessonId;

    public Long getMarkId() {
        return markId;
    }

    public void setMarkId(Long markId) {
        this.markId = markId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Lesson getLessonId() {
        return lessonId;
    }

    public void setLessonId(Lesson lessonId) {
        this.lessonId = lessonId;
    }
}
