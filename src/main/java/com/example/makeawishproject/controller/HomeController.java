package com.example.makeawishproject.controller;
import com.example.makeawishproject.model.Item;
import com.example.makeawishproject.model.User;
import com.example.makeawishproject.model.WishList;
import com.example.makeawishproject.service.ItemService;
import com.example.makeawishproject.service.UserService;
import com.example.makeawishproject.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private WishListService wishListService;

    @Autowired
    private ItemService itemService;

    @Autowired
    UserService userService;

    private int user_id;


    @GetMapping("/")
    public String frontPage () {
        return "home/frontPage";
    }

    @GetMapping("/registration")
    public String registrationSection() {
        return "home/registration";
    }

    @PostMapping("/newRegistration")
    public String NewRegistration(@ModelAttribute User user, @RequestParam("username") String username,
                                  @RequestParam("user_password") String user_password){
        userService.createNewUser(user);
        user_id = userService.getUser_id(username, user_password);
        return "home/homePage";
    }

    @PostMapping ("/login")
    public String login(@RequestParam("username") String username, @RequestParam("user_password")
    String user_password, Model model)
    {
        model.addAttribute("user", userService.validateLogin(username, user_password));

        if (userService.validateLogin(username, user_password))
        {
            user_id = userService.getUser_id(username, user_password);
            return "redirect:/homePage";
        }
        else
        {
            return "home/frontPage";
        }
    }

    @GetMapping("/homePage")
    public String homePageWishList(Model model) {
        List<WishList> wishLists = wishListService.fetchWishList(user_id);
        model.addAttribute("wishlists", wishLists);
        return "home/homePage";
    }

    @GetMapping("/homePageAddItem")
    public String homePageAddItem(Model model){
        List<Item> items = itemService.fetchItems();
        model.addAttribute("items",items );
        return "home/homePage";
    }


    @PostMapping("/makeList")
    public String makeList(@ModelAttribute WishList wishList) {
        wishListService.createWishList(wishList, user_id);
        return "redirect:/homePage";
    }

    @GetMapping("/createList")
    public String createList(){
        return "home/createList";
    }

    @GetMapping("/discoveryPage")
    public String discoveryPage(Model model) {
        List<WishList> wishlist = wishListService.discovery();
        model.addAttribute("lists", wishlist);
        return "home/discoveryPage";
    }

    @GetMapping("/viewWishlistFromSearchbar")
    public String viewWishlistFromSearchbar(@RequestParam("wishlist_id") int wishlist_id, Model model) {

        List<WishList> wishlists = wishListService.findWishlist(wishlist_id);
        model.addAttribute("wishlists", wishlists);

        List<Item> items = itemService.viewWishlist(wishlist_id);
        model.addAttribute("items", items);

        return "home/showWishlist";
    }

    @GetMapping("/addItem/{wishlist_id}")
    public String addItem(@PathVariable("wishlist_id") int wishlist_id, Model model) {
        model.addAttribute("wishlist_id", wishlist_id);
        return "home/addItem";
    }

    @PostMapping("/addItemToWishlist")
    public String addItemToWishlist(@ModelAttribute Item i) {
        itemService.addItem(i);
        return "redirect:/homePage";
    }

    @GetMapping("/viewWishList/{wishlist_id}")
    public String viewWishList(@PathVariable("wishlist_id") int wishlist_id, Model model) {
        List<Item> items = itemService.viewWishlist(wishlist_id);
        model.addAttribute("items", items);
        System.out.println(items);
        return "home/viewWishList";
    }

    @GetMapping("/deleteWishlist/{id}")
    public String deleteWishlist(@PathVariable("id") int id) {
        boolean deleted = wishListService.deleteWishlist(id);
        if (deleted) {
            return "redirect:/homePage";
        } else {
            return "redirect:/homePage";
        }
    }

    @PostMapping("/reserveItem")
    public String reserveItem(@ModelAttribute Item i){
        itemService.reserveItem(i);
        return "redirect:/homePage";
    }
}

