package com.journal.app.repositories;

import com.journal.app.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** Интерфейс для запросов в таблицу "учителя" базы данных
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface TeachersRepository extends JpaRepository<Teacher, Long> {

    @Query(value = "SELECT teacher_id, second_name, name, patronymic FROM teachers WHERE teacher_id = (SELECT teacher_id FROM users WHERE login =?)", nativeQuery = true)
    Teacher findTeacherByLogin(String login);
}
