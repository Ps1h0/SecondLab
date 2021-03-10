package com.journal.app.controllers;

import com.journal.app.models.Teacher;
import com.journal.app.repositories.LessonsRepository;
import com.journal.app.repositories.ScheduleRepository;
import com.journal.app.repositories.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**Class controller of attendance. Transitions to child pages defined
 * @author Danil Belonogov
 */
@Controller
public class AttendanceController {
    @Autowired
    TeachersRepository teachersRepository;
    @Autowired
    LessonsRepository lessonsRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    /** Transit to attendance of subject
     * @param id - identifier of subject
     * @param model - for add data to web-page
     * @return web-page "attendance/{id}"
     */
    @RequestMapping("/attendance/{id}")
    public String attendancePage(@PathVariable("id") Long id, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        model.addAttribute("lesson", lessonsRepository.getOne(id));
        model.addAttribute("teacher", teacher);
        return "attendance";
    }
}
