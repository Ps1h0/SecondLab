package com.journal.app.controllers;

import com.journal.app.models.Lesson;
import com.journal.app.models.Teacher;
import com.journal.app.repositories.LessonsRepository;
import com.journal.app.repositories.TeachersRepository;
import com.journal.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class JournalController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TeachersRepository teachersRepository;

    @Autowired
    LessonsRepository lessonsRepository;

    @RequestMapping("/journal")
    public String journalPage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
                model.addAttribute("teacher", teacher);
        return "journal";
    }
    @RequestMapping("journal/subjects")
    public String getSubjects(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        Long id = teacher.getTeacherId();
        Iterable<Lesson> lessons = lessonsRepository.getLessons(id);
        model.addAttribute("lessons", lessons);
        model.addAttribute("teacher",teacher);
        return "subjects";
    }
}
