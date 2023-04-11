package com.example.makeawishproject.controller;
import com.example.makeawishproject.model.User;
import com.example.makeawishproject.model.WishList;
import com.example.makeawishproject.service.UserService;
import com.example.makeawishproject.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/addItem/{wishlistId}/{wishlistName}")
    public String addItemForm(@PathVariable("wishlistId") Long wishlistId, @PathVariable("wishlistName") String wishlistName, Model model){
        model.addAttribute("wishlistId", wishlistId);
        model.addAttribute("wishlistName", wishlistName);
        return "home/addItem";
    }

    @PostMapping("/addItemToWishlist")
    public String addItemToWishlist(@ModelAttribute("wishList") WishList wishList){
        wishListService.updateAddItem(wishList.getWishlist_id(), wishList.getWishlist_name(), wishList.getItem_name(), wishList.getItem_description());
        return "redirect:/"; // redirect to the home page
    }

    @GetMapping("/deleteWishlist/{id}")
    public String deleteWishlist(@PathVariable("id")int id){
        boolean deleted= wishListService.deletewishlist(id);
        if (deleted) {
            return "redirect:/";
        }
        else {
            return "redirect:/";
        }
    }
    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable("id")int id){
        boolean deleted= wishListService.deleteItem(id);
        if (deleted) {
            return "redirect:/";
        }
        else {
            return "redirect:/";
        }
    }
}
