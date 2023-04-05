package com.example.makeawishproject.controller;
import org.springframework.ui.Model;
import com.example.makeawishproject.service.UserService;
import com.example.makeawishproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String frontPage () {
        return "home/frontPage";
    }

    @GetMapping("/registration")
    public String registrationSection() {
        return "home/registration";
    }

    @PostMapping("/NewRegistration")
    public String NewRegistration(@ModelAttribute User userModel) {
        userService.createNewUser(userModel);
        return "redirect:/";
    }

    @PostMapping ("/login/{username}/{user_password}")
    public String login(@RequestParam ("username") String username, @RequestParam("user_password")
    String user_password, Model model) {
        model.addAttribute("user", userService.validateLogin(username, user_password));

        if(userService.validateLogin(username, user_password)) {
            return "home/test";
        }
        else {
            return "home/wrongLogin";
        }
    }

}
