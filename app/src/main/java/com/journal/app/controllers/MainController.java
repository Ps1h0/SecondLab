package com.journal.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** Класс контроллер главной страницы приложения. Определен переход к аутентификации
 * @author Nikita Platonov
 */
@Controller
public class MainController {

    /** Метод перехода на главную страницу приложения
     * @return index page
     */
    @RequestMapping("/")
    public String homePage(){
        return "index";
    }

    /** Метод перехода на страницу аутентификации пользователя.
     * @param error
     * @param model
     * @see Model
     * @return sign in page
     */
    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           Model model){
        model.addAttribute("error", error != null);
        return "signin";
    }
}
