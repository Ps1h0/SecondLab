package com.journal.app.repositories;

import com.journal.app.models.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons, Long> {
}
