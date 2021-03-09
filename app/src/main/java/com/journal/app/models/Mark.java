package com.journal.app.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/** Table "marks" of database.
 * @author Nikita Platonov
 */
@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mark_id")
    private Long markId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "date")
    private Date date;

    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "teacher_id")
    private Long teacherID;

    public Mark(Long markId, Long studentId, Integer mark, Date date, Long lessonId, Long teacherID) {
        this.markId = markId;
        this.studentId = studentId;
        this.mark = mark;
        this.date = date;
        this.lessonId = lessonId;
        this.teacherID = teacherID;
    }

    public Mark() {
    }

    public Long getMarkId() {
        return markId;
    }

    public void setMarkId(Long markId) {
        this.markId = markId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getDate() {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        return formatDate.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Long teacherID) {
        this.teacherID = teacherID;
    }
}
