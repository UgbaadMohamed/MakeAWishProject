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


    public List<WishList> fetchWishList(){
        return wishListRepo.fetchWishList();
    }

    public void createWishList(WishList w){
        wishListRepo.createWishList(w);
    }

    public void updateAddItem(int wishlistId, String wishlistName, String itemName, String itemDescription) {
        wishListRepo.updateAddItem(wishlistId, wishlistName, itemName, itemDescription);
    }

    public Boolean deletewishlist(int id){
        return wishListRepo.deletewishlist(id);
    }
    public Boolean deleteItem(int id){
        return wishListRepo.deleteItem(id);
    }
}

