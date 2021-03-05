package com.journal.app.repositories;

import com.journal.app.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Интерфейс для запросов в таблицу "расписание" базы данных
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
