package com.journal.app.repositories;

import com.journal.app.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Интерфейс для запросов в таблицу "группы" базы данных
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface GroupsRepository extends JpaRepository<Group, Long> {
}
