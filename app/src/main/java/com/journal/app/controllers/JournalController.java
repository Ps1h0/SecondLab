package com.journal.app.controllers;

import com.journal.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JournalController {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/journal")
    public String journalPage(Model model){
        //model.addAttribute();
        return "journal";
    }
}
