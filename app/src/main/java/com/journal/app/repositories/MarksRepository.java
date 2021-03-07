package com.journal.app.repositories;

import com.journal.app.models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Интерфейс для запросов в таблицу "оценки" базы данных
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface MarksRepository extends JpaRepository<Mark, Long> {
}
