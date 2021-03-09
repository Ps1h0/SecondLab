package com.journal.app.controllers;

import com.journal.app.models.Lesson;
import com.journal.app.models.Mark;
import com.journal.app.models.Teacher;
import com.journal.app.repositories.LessonsRepository;
import com.journal.app.repositories.MarksRepository;
import com.journal.app.repositories.TeachersRepository;
import com.journal.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Iterable<Mark> marks = marksRepository.getMarksByLessonId(id);
        model.addAttribute("lesson", lessonsRepository.getOne(id));
        model.addAttribute("teacher",teacher);
        model.addAttribute("marks", marks);
        return "subject";
    }

    @RequestMapping("/subject/{id}/update")
    public String updateSubject(@PathVariable("id") Long id, @ModelAttribute("marks") Iterable<Mark> marks){
        marksRepository.saveAll(marks);
        return "redirect:/subject/{id}";
    }
}