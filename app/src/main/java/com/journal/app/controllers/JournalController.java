package com.journal.app.controllers;

import com.journal.app.models.Lesson;
import com.journal.app.models.Schedule;
import com.journal.app.models.Teacher;
import com.journal.app.repositories.LessonsRepository;
import com.journal.app.repositories.ScheduleRepository;
import com.journal.app.repositories.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**Class controller of teacher's journal application. Journal page transitions and child pages defined
 * @author Nikita Platonov
 */
@Controller
public class JournalController {
    @Autowired
    TeachersRepository teachersRepository;
    @Autowired
    LessonsRepository lessonsRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    /**Transition to the journal page after user authentication
     * @see Model
     * @see Authentication
     * @see Teacher
     * @param model - for add data to web-page
     * @return journal page
     */
    @RequestMapping("/journal")
    public String journalPage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        model.addAttribute("teacher", teacher);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        String data = dateFormat.format(date);
//        List<Schedule> schedules = scheduleRepository.getSchedulesByTeacherIdAndDayOrderByTime(teacher.getTeacherId(), data);
        List<Schedule> schedules = scheduleRepository.getSchedulesByTeacherIdAndDayOrderByTime(teacher.getTeacherId(),  "понедельник");
        int n = schedules.size();
        Lesson[] lessons = new Lesson[n];
        for (int i = 0; i < n; i++){
            lessons[i] = lessonsRepository.getOne(schedules.get(i).getLessonId());
        }
        model.addAttribute("lessons", lessons);
        model.addAttribute("schedules", schedules);
        return "journal";
    }
}
