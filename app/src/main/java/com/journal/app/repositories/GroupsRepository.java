package com.journal.app.repositories;

import com.journal.app.models.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepository extends JpaRepository<Groups, Long> {
}
