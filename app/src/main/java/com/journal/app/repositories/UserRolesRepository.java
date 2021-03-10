package com.journal.app.repositories;

import com.journal.app.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Interface for requests to table "user_roles"
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface UserRolesRepository extends JpaRepository<UserRole, Long> {
}
