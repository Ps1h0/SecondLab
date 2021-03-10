package com.journal.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**Class controller of main page of application. Defined transition to authentication
 * @author Nikita Platonov
 */
@Controller
public class MainController {

    /** Transit to main page of application
     * @return index page
     */
    @RequestMapping("/")
    public String homePage(){
        return "index";
    }

    /**Transit to user authentication page
     * @param error - to display an authentication error message
     * @param model - for add data to web-page
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
