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



    public Boolean deletewishlist(int id){
        return wishListRepo.deletewishlist(id);
    }

}

