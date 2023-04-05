package com.example.makeawishproject.controller;

import com.example.makeawishproject.Service.UserService;
import com.example.makeawishproject.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String NewRegistration(@ModelAttribute UserModel userModel) {
        userService.NewUser(userModel);
        return "redirect:/";
    }
}
