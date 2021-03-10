//package com.journal.app.repositories;
//
//import com.journal.app.models.MarksStudents;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface MarksStudentsRepository extends JpaRepository<MarksStudents, Long> {
//
//    @Query(value = "SELECT students.second_name, students.name, students.patronymic, marks.mark, marks.date
//    FROM (schedule
//    INNER JOIN lessons ON schedule.lesson_id = lessons.lesson_id
//    INNER JOIN marks ON lessons.lesson_id = marks.lesson_id
//    INNER JOIN students ON marks.student_id = students.student_id)
//    WHERE schedule.teacher_id = ? and schedule.lesson_id = ?", nativeQuery = true)
//    Iterable<MarksStudents> getMarksStudentsByTeacherIdAndLessonId(Long teacherId, Long LessonId);
//}
