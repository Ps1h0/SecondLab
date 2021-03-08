package com.journal.app.models;

import javax.persistence.*;
import java.sql.Date;

/** Класс, соответствующий таблице "посещаемость" в базе данных, предназначен для хранения данных
 * @author Nikita Platonov
 */
@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "date")
    private Date date;

    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "presence")
    private boolean presence;

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Date getDate() {
        return date;
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

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }
}
