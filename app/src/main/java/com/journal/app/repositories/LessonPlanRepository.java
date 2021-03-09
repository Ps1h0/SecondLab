package com.journal.app.repositories;

import com.journal.app.models.LessonPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LessonPlanRepository extends JpaRepository<LessonPlan, Long> {

    List<LessonPlan> getLessonPlansByDateAndTeacherIdAndLessonId(Date date, Long teacherId, Long lessonId);

}
