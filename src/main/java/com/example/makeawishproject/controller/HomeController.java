package com.example.makeawishproject.controller;
import com.example.makeawishproject.model.Item;
import com.example.makeawishproject.model.WishList;
import com.example.makeawishproject.service.ItemService;
import com.example.makeawishproject.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    WishListService wishListService;
    @Autowired
    UserService userService;
    @Autowired
    ItemService itemService;

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
    public String homePageWishList(Model model) {
        List<WishList> wishLists = wishListService.fetchWishList();
        model.addAttribute("wishlists", wishLists);
        return "home/homePage";
    }
    @GetMapping("//")
    public String homePageAddItem(Model model){
        List<Item> items = itemService.fetchItems();
        model.addAttribute("items",items );
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



    @GetMapping("/discoveryPage")
    public String discoveryPage(Model model){
        List<WishList> wishlist = wishListService.discovery();
        model.addAttribute("lists", wishlist);
        return "home/discoveryTest";
    @GetMapping("/addItem")
    public String addItem() {
        return "home/addItem";
    }

    @PostMapping("/addItemToWishlist")
    public String addItemToWishlist(@ModelAttribute Item i){
        //itemService.addItem(i.getWishlist_id(), i.getItem_id(), i.getItem_name(), i.getItem_description());
        itemService.addItem(i);
        return "redirect:/"; // redirect to the home page
    }


    @GetMapping("/viewWishList/{wishlist_id}")
    public String viewWishList(@PathVariable("wishlist_id") int wishlist_id,Model model) {
        List<Item> items =itemService.viewWishlist(wishlist_id);
        model.addAttribute("items", items);
        System.out.println(items);
        return "home/viewWishList";
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
        boolean deleted= itemService.deleteItem(id);
        if (deleted) {
            return "redirect:/";
        }
        else {
            return "redirect:/";
        }
    }


}
