package com.journal.app.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

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

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Student> studentId;

    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lessonId;

    @Column(name = "presence")
    private boolean presence;

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Collection<Student> getStudentId() {
        return studentId;
    }

    public void setStudentId(Collection<Student> studentId) {
        this.studentId = studentId;
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

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }
}
