package com.journal.app.controllers;

import com.journal.app.models.Lesson;
import com.journal.app.models.LessonPlan;
import com.journal.app.models.Teacher;
import com.journal.app.repositories.LessonPlanRepository;
import com.journal.app.repositories.LessonsRepository;
import com.journal.app.repositories.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**Class controller of lesson plans. Transitions to child pages defined
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Controller
public class LessonPlanController {

    @Autowired
    TeachersRepository teachersRepository;

    @Autowired
    LessonsRepository lessonsRepository;

    @Autowired
    LessonPlanRepository lessonPlanRepository;


    /**Returns web-page for add plans
     * @param id - identifier of subject
     * @param date - date
     * @param model - for add data to web page
     * @return web-page "plan-add"
     * @throws ParseException for {@link SimpleDateFormat}
     */
    @RequestMapping("/plan/{id}/{date}")
    public String addLessonPlan(@PathVariable("id") Long id, @PathVariable("date") String date, Model model) throws ParseException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        Lesson lesson = lessonsRepository.getOne(id);
        Date dateformat = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Iterable<LessonPlan> lessonPlans = lessonPlanRepository.getLessonPlansByDateAndTeacherIdAndLessonId(dateformat, teacher.getTeacherId(), lesson.getLessonId());
        model.addAttribute("teacher", teacher);
        model.addAttribute("lesson", lesson);
        model.addAttribute("lessonPlans", lessonPlans);
        model.addAttribute("date", dateformat);
        return "plan-add";
    }

    /**Method for adding new plans
     * @param lessonPlan - plan of lesson
     * @return web-page "plan-add"
     */
    @PostMapping("/plan/update")
    public String updatePlan(@ModelAttribute("planupdate") LessonPlan lessonPlan){
        lessonPlanRepository.save(lessonPlan);
        return "redirect:plan-add";
    }
}
