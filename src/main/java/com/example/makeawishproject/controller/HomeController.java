package com.example.makeawishproject.controller;
import com.example.makeawishproject.Service.UserService;
import com.example.makeawishproject.Service.WishListService;
import com.example.makeawishproject.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.makeawishproject.model.WishList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    WishListService wishListService;

    @GetMapping("/")
    public String frontPage () {
        return "home/SearchWishlist";
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




    @GetMapping("/registration")
    public String registrationSection() {
        return "home/registration";
    }

    @PostMapping("/NewRegistration")
    public String NewRegistration(@ModelAttribute UserModel userModel) {
        userService.NewUser(userModel);
        return "redirect:/";
    }
    @GetMapping("/viewSearch/{wishlist_id}")
    public String viewSearch(@RequestParam("wishlist_id") int wishlist_id,Model model) {
        model.addAttribute("wishlist",wishListService.findWishlist(wishlist_id));
        return "home/ShowSearch";
    }

}
