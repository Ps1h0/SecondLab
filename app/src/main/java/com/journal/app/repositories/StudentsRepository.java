package com.journal.app.repositories;

import com.journal.app.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Интерфейс для запросов в таблицу "студенты" базы данных
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
}
