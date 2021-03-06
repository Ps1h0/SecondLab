package com.journal.app.controllers;

import com.journal.app.models.Group;
import com.journal.app.models.Teacher;
import com.journal.app.repositories.GroupsRepository;
import com.journal.app.repositories.LessonsRepository;
import com.journal.app.repositories.TeachersRepository;
import com.journal.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GroupsController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TeachersRepository teachersRepository;

    @Autowired
    LessonsRepository lessonsRepository;

    @Autowired
    GroupsRepository groupsRepository;

    @RequestMapping("/journal/groups")
    public String getMyGroups(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        model.addAttribute("teacher",teacher);
        Long id = teacher.getTeacherId();
        Iterable<Group> groups = groupsRepository.getGroups(id);
        model.addAttribute("groups",groups);
        return "groups";
    }

}
