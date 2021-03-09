package com.journal.app.controllers;

import com.journal.app.models.*;
import com.journal.app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/** Class controller of subjects page. Defined transition to subject from the list
 * @author Nikita Platonov
 * @author Danil Belonogov
 */
@Controller
public class SubjectsController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TeachersRepository teachersRepository;

    @Autowired
    LessonsRepository lessonsRepository;

    @Autowired
    MarksRepository marksRepository;

    @Autowired
    LessonPlanRepository lessonPlanRepository;

    /**Transit to teacher's subjects page
     * @see Model
     * @see Authentication
     * @see Teacher
     * @see Lesson
     * @param model - for add data to web-page
     * @return subjects page
     */
    @RequestMapping("/subjects")
    public String getSubjects(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        Long id = teacher.getTeacherId();
        Iterable<Lesson> lessons = lessonsRepository.getLessonsByTeacher(id);
        model.addAttribute("lessons", lessons);
        model.addAttribute("teacher",teacher);
        return "subjects";
    }

    /**Transit to teacher's subject from the list
     * @see Model
     * @see Authentication
     * @param id - identifier of subject
     * @param model - for add data to web-page
     * @return - web-page "subject/{id}"
     */
    @RequestMapping("/subject/{id}")
    public String getSubjectById(@PathVariable("id") Long id, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        List<Mark> marks = marksRepository.getDistinctByLessonIdAndTeacherID(id, teacher.getTeacherId());
        List<Date> dates = marksRepository.getDatesByLessonIdAndTeacherID(id, teacher.getTeacherId());
        model.addAttribute("lesson", lessonsRepository.getOne(id));
        model.addAttribute("teacher",teacher);
        model.addAttribute("marks", marks);
        model.addAttribute("dates", dates);
        return "subject";
    }

//    @PostMapping("/subject/update")
//    public String updateSubject(@ModelAttribute("marks") Iterable<Mark> marks){
//        marksRepository.saveAll(marks);
//        marksRepository.flush();
//        return "redirect:subject";
//    }

//    @GetMapping("/subject/update_plan")
//    public String updatePlan(Model model){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        Teacher teacher = teachersRepository.findTeacherByLogin(name);
//        List<LessonPlan> lessonPlans = lessonPlanRepository.
//        return "redirect:subject";
//    }
}