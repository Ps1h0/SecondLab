package com.journal.app.repositories;

import com.journal.app.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** Интерфейс для запросов в таблицу "уроки" базы данных
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface LessonsRepository extends JpaRepository<Lesson, Long> {
    @Query(value = "SELECT name, hours, lesson_id FROM lessons WHERE lesson_id = " +
            "ANY (SELECT lesson_id FROM schedule WHERE teacher_id = " +
            "(SELECT teacher_id FROM teachers WHERE teacher_id=? ))", nativeQuery = true)
    Iterable<Lesson> getLessons(Long id);

    Lesson getLessonByLessonId(Long id);

}


