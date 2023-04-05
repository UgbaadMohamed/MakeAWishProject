package com.example.makeawishproject.controller;
import com.example.makeawishproject.model.WishList;
import com.example.makeawishproject.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    WishListService wishListService;

    @GetMapping("/")
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
        return "redirect:/";
    }



}
