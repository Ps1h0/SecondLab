package com.journal.app.repositories;

import com.journal.app.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

/** Интерфейс для запросов в таблицу "посещаемость" базы данных
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Iterable<Attendance> getAttendancesByLessonIdAndDate(Long id,Date date);

    @Query(value = "SELECT distinct date FROM attendance WHERE lesson_id = ?",nativeQuery = true)
    Iterable<Date> getDistinctByLessonIdCus(Long id);

    Iterable<Attendance> getDistinctByLessonId(Long id);
}
