package com.journal.app.controllers;

import com.journal.app.models.*;
import com.journal.app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    AttendanceRepository attendanceRepository;

    /** Метод перехода на страницу предметов преподавателя
     * @see Model
     * @see Authentication
     * @see Teacher
     * @param model - для добавления данных на веб-страницу
     * @return subjects page
     */
    @RequestMapping("/subjects")
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

    @RequestMapping("/subject/{id}")
    public String getSubjectById(@PathVariable("id") Long id, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        List<Mark> marks = marksRepository.getDistinctByLessonIdAndTeacherId(id, teacher.getTeacherId());
        List<Date> dates = marksRepository.getDatesByLessonIdAndTeacherID(id, teacher.getTeacherId());
        model.addAttribute("lesson", lessonsRepository.getOne(id));
        model.addAttribute("teacher",teacher);
        model.addAttribute("marks", marks);
        model.addAttribute("dates", dates);
        return "subject";
    }

//    @RequestMapping("/subject/{date}")
//    public String getPlan(@PathVariable("date") String date, Model model){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        Teacher teacher = teachersRepository.findTeacherByLogin(name);
//        List<LessonPlan> lessonPlans =
//
//        return "plan";
//    }
    @RequestMapping("/attendance/{id}")
    public String getAttendance(@PathVariable("id") Long id, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        Lesson lesson = lessonsRepository.getOne(id);
        Iterable<Date> dates = attendanceRepository.getDistinctByLessonIdCus(lesson.getLessonId());
        Iterable<Attendance> attendances = attendanceRepository.getDistinctByLessonId(lesson.getLessonId());
        model.addAttribute("lesson",lesson);
        model.addAttribute("teacher",teacher);
        model.addAttribute("attendances",attendances);
        model.addAttribute("dates",dates);
        return "attendances";
    }
    @GetMapping ("/attendance/{id}/{date}")
    public String getAttendanceByDate(@PathVariable("id") Long id, @PathVariable("date") String date, Model model) throws ParseException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        Lesson lesson = lessonsRepository.getOne(id);
        Date datee=new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Iterable<Attendance> attendances = attendanceRepository.getAttendancesByLessonIdAndDate(id,datee);
        model.addAttribute("lesson",lesson);
        model.addAttribute("teacher",teacher);
        model.addAttribute("attendances",attendances);
        return "attendance";
    }



}
