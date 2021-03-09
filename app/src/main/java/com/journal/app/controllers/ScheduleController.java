package com.journal.app.controllers;

import com.journal.app.models.Schedule;
import com.journal.app.models.Teacher;
import com.journal.app.repositories.ScheduleRepository;
import com.journal.app.repositories.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**Class controller of schedule. Transit to schedule page defined
 * @author Danil Belonogov
 */
@Controller
public class ScheduleController {

    @Autowired
    TeachersRepository teachersRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    /**Transit to schedule page.
     * @param model - for add data to web-page
     * @return web-page "schedule"
     */
    @RequestMapping("/schedule")
    public String schedulePage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        Iterable<Schedule> schedules = scheduleRepository.getScheduleByTeacherIdOrderByTime(teacher.getTeacherId());
        model.addAttribute("teacher", teacher);
        model.addAttribute("schedules", schedules);
        return "schedule";
    }
}
