package com.example.makeawishproject.service;


import com.example.makeawishproject.model.WishList;
import com.example.makeawishproject.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {
@Autowired
    WishListRepo wishListRepo;


    public List<WishList> fetchWishList(int user_id){
        return wishListRepo.fetchWishList(user_id);
    }

    public void createWishList(WishList w, int user_id){
        wishListRepo.createWishList(w, user_id);
    }


    public Boolean deleteWishlist(int id){
        return wishListRepo.deleteWishlist(id);

        }
    public List<WishList> discovery(){
        return wishListRepo.discoveryPage();
    }

    public List<WishList> findWishlist (int wishlist_id) {
        return wishListRepo.findWishlist(wishlist_id);
    }




}

