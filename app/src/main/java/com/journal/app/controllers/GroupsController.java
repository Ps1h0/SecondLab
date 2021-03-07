package com.journal.app.controllers;

import com.journal.app.models.Group;
import com.journal.app.models.Student;
import com.journal.app.models.Teacher;
import com.journal.app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    StudentsRepository studentsRepository;

    @RequestMapping("/groups")
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
    @RequestMapping("/group/{id}")
    public String getGroupById(@PathVariable("id") Long id, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Teacher teacher = teachersRepository.findTeacherByLogin(name);
        model.addAttribute("teacher",teacher);
        Iterable<Student> students = studentsRepository.getStudentsByGroupId(id);
        model.addAttribute("students",students);
        Group group = groupsRepository.getOne(id);
        model.addAttribute("group",group);

        return "group";
    }


}
