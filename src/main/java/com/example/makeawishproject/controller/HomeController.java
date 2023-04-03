package com.example.makeawishproject.controller;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String index(){

        return "home/frontPage";
    }

}
