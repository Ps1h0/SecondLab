package com.journal.app.repositories;

import com.journal.app.models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends JpaRepository<Mark, Long> {
}
