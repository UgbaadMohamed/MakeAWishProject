package com.example.makeawishproject.controller;
import com.example.makeawishproject.model.User;
import com.example.makeawishproject.model.WishList;
import com.example.makeawishproject.service.UserService;
import com.example.makeawishproject.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    WishListService wishListService;
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
    public String NewRegistration(@ModelAttribute User user) {
        userService.createNewUser(user);
        return "home/homePage";
    }

    @PostMapping ("/login/{username}/{user_password}")
    public String login(@RequestParam("username") String username, @RequestParam("user_password")
    String user_password, Model model) {
        model.addAttribute("user", userService.validateLogin(username, user_password));

        if(userService.validateLogin(username, user_password)) {
            return "home/homePage";
        }
        else {
            return "home/wrongLogin";
        }
    }

    @GetMapping("/homePage")
    public String homePage(Model model){
        List<WishList> wishList = wishListService.fetchWishList();
        model.addAttribute("wishlists",wishList);
        return "home/homePage";
    }

    @GetMapping("/createList")
    public String createList(){
        return "home/createList";
    }


    @PostMapping("/makeList")
    public String makeList(@ModelAttribute WishList wishList){
        wishListService.createWishList(wishList);
        return "home/homePage";
    }


    @GetMapping("/discoveryPage")
    public String discoveryPage(Model model){
        List<WishList> wishlist = wishListService.discovery();
        model.addAttribute("lists", wishlist);
        return "home/discoveryTest";
    }



}
