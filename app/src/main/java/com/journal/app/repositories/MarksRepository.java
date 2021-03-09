package com.journal.app.repositories;

import com.journal.app.models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/** Interface for requests to table "marks"
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface MarksRepository extends JpaRepository<Mark, Long> {

    Iterable<Mark> getMarksByLessonId(Long id);

//    @Query(value = "SELECT DISTINCT date FROM marks WHERE lesson_id = ? and teacher_id = ?", nativeQuery = true)
//    List<Date> getDatesByLessonIdAAndTeacherID(Long lessonId, Long teacherId);
}
