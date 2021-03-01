package com.journal.app.repositories;

import com.journal.app.models.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachersRepository extends JpaRepository<Teachers, Long> {
}
