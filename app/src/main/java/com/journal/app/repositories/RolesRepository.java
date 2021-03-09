package com.journal.app.repositories;

import com.journal.app.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Interface for requests to table "roles"
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {
}
