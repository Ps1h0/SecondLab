package com.journal.app.models;

import javax.persistence.*;
import java.sql.Time;

/** Класс, соответствующий таблице "расписание" в базе данных, предназначен для хранения данных
 * @author Nikita Platonov
 */
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "day")
    private String day;

    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "auditorium")
    private String auditorium;

    @Column(name = "time")
    private String time;

    @Column(name = "teacher_id")
    private Long teacherId;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
