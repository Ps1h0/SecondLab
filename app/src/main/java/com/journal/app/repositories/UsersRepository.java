package com.journal.app.repositories;

import com.journal.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Interface for requests to table "users"
 * @author Nikita Platonov, Danil Belonogov
 * @author Danil Belonogov
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
