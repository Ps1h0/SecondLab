package com.journal.app.repositories;


import com.journal.app.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** Interface for requests to table "groups"
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface GroupsRepository extends JpaRepository<Group, Long> {
    @Query(value = "select name, group_id from groups WHERE groups.group_id =" +
            " ANY (select group_id from students where student_id = " +
            "ANY (select student_id from attendance where lesson_id = " +
            "ANY (select lesson_id from lessons where lesson_id = " +
            "ANY (select lesson_id from schedule where teacher_id = " +
            "(select teacher_id from teachers where teacher_id = ?1)))))", nativeQuery = true)
    Iterable<Group> getGroups(Long id);

}