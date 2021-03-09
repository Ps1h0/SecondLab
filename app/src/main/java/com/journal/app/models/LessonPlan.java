package com.journal.app.models;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "lesson_plan")
public class LessonPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="teacher_id")
    private Long teacherId;

    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "date")
    private Date date;

    @Column(name = "plan")
    private String plan;

    @Column(name = "is_done")
    private boolean isDone;

    public LessonPlan() {
    }

    public LessonPlan(Long id, Long teacherId, Long lessonId, Date date, String plan, boolean isDone) {
        this.id = id;
        this.teacherId = teacherId;
        this.lessonId = lessonId;
        this.date = date;
        this.plan = plan;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
