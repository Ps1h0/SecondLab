package com.journal.app.repositories;

import com.journal.app.models.MarksStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksStudentsRepository extends JpaRepository<MarksStudents, Long> {

    @Query(value = "SELECT students.second_name, students.name, students.patronymic, marks.date, marks.mark, attendance.presence " +
            "FROM students, marks, attendance WHERE marks.student_id = " +
            "ANY (SELECT students.student_id FROM students WHERE students.student_id = " +
            "ANY (SELECT attendance.student_id FROM attendance WHERE attendance.lesson_id = " +
            "ANY (SELECT lessons.lesson_id FROM lessons WHERE lessons.lesson_id = ? AND lessons.lesson_id = " +
            "ANY (SELECT schedule.lesson_id FROM schedule WHERE schedule.teacher_id = ?))))", nativeQuery = true)
    Iterable<MarksStudents> getHueta();
}
