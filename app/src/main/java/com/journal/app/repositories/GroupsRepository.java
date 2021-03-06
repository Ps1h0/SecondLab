package com.journal.app.repositories;


import com.journal.app.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** Интерфейс для запросов в таблицу "группы" базы данных
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface GroupsRepository extends JpaRepository<Group, Long> {
    @Query(value = "select name,group_id from jurnalshema.groups WHERE group_id =" +
            " ANY (select group_id from jurnalshema.students where student_id = " +
            "ANY (select student_id from jurnalshema.attendance where lesson_id = " +
            "ANY (select lesson_id from jurnalshema.lessons where lesson_id = " +
            "ANY (select lesson_id from jurnalshema.schedule where teacher_id = " +
            "(select teacher_id from jurnalshema.teachers where teacher_id = ?1)))))", nativeQuery = true)
    Iterable<Group> getGroups(Long id);

}
