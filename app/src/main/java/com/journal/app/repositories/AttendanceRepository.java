package com.journal.app.repositories;

import com.journal.app.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**Interface for requests to table "attendance"
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
