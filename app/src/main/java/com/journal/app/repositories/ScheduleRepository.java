package com.journal.app.repositories;

import com.journal.app.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Интерфейс для запросов в таблицу "расписание" базы данных
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(value = "SELECT * FROM schedule WHERE day=? AND teacher_id = ?",nativeQuery = true)
    List<Schedule> getSchedulesByTeacherIdAndDay(String day,Long id);
}
