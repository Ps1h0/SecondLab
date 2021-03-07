package com.journal.app.controllers;

import com.journal.app.models.Teacher;
import com.journal.app.repositories.LessonsRepository;
import com.journal.app.repositories.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** Класс контроллер журнала преподавателя. Определены переходы на страницу журнала и дочерние страницы
 * @author Nikita Platonov
 */
@Controller
public class JournalController {
    @Autowired
    TeachersRepository teachersRepository;
    @Autowired
    LessonsRepository lessonsRepository;

    /** Метод перехода на страницу журнала преподавателя после аутентификации пользователя
     * @see Model
     * @see Authentication
     * @see Teacher
     * @param model - для добавления данных на веб-страницу
     * @return journal page
     */
    @RequestMapping("/journal")
    public String journalPage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
                model.addAttribute("teacher", teacher);
        return "journal";
    }
}
