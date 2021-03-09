package com.journal.app.repositories;

import com.journal.app.models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/** Интерфейс для запросов в таблицу "оценки" базы данных
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface MarksRepository extends JpaRepository<Mark, Long> {

    List<Mark> getDistinctByLessonIdAndTeacherId(Long lessonId, Long teacherId);

    @Query(value = "SELECT DISTINCT date FROM marks WHERE lesson_id = ? and teacher_id = ?", nativeQuery = true)
    List<Date> getDatesByLessonIdAndTeacherID(Long lessonId, Long teacherId);
}
