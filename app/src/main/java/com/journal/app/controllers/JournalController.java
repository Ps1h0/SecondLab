package com.journal.app.controllers;

import com.journal.app.models.Lesson;
import com.journal.app.models.Logger;
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

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/** Класс контроллер журнала преподавателя. Определены переходы на страницу журнала и дочерние страницы
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


    /** Метод перехода на страницу журнала преподавателя после аутентификации пользователя
     * @see Model
     * @see Authentication
     * @see Teacher
     * @param model - для добавления данных на веб-страницу
     * @return journal page
     */
    @RequestMapping("/journal")
    public String journalPage(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        model.addAttribute("teacher", teacher);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");

        String day = simpleDateFormat.format(date);


        List<Schedule> schedules = scheduleRepository.getSchedulesByTeacherIdAndDay(day,teacher.getTeacherId());
        int n = schedules.size();
        Lesson lessons[] = new Lesson[n];

        for (int i=0;i<n;i++){
            lessons[i]=lessonsRepository.getOne(schedules.get(i).getLessonId());
        }
        model.addAttribute("lessons",lessons);
        model.addAttribute("schedules",schedules);
        Logger logger = new Logger();
        logger.createLog(name+" зашел в ститему");
        return "journal";
    }



}
