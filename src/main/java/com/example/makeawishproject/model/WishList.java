package com.example.makeawishproject.model;

public class WishList {

    private String wishlist_name;
    private int wishlist_id;
    private String wishlist_description;

    private int count;


    public WishList(){
    }

    public WishList(int wishlist_id, String wishlist_name,String wishlist_description)  {
        this.wishlist_id = wishlist_id;
        this.wishlist_name = wishlist_name;
        this.wishlist_description = wishlist_description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }
    public String getWishlist_description() {
        return wishlist_description;
    }

    public void setWishlist_description(String wishlist_description) {
        this.wishlist_description = wishlist_description;
    }

    public String getWishlist_name() {
        return wishlist_name;
    }

    public void setWishlist_name(String wishlist_name) {
        this.wishlist_name = wishlist_name;
    }



}
