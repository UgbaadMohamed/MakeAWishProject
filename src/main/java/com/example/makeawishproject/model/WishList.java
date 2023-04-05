package com.example.makeawishproject.model;

public class WishList {

    private String wishlist_name;
    private String item_name;
    private String item_description;
    private int wishlist_id;


    public WishList(){
    }

    public WishList(int item_id,String wishlist_name, String item_name, String item_description)  {
        this.wishlist_id = item_id;
        this.wishlist_name = wishlist_name;
        this.item_name = item_name;
        this.item_description = item_description;
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public String getWishlist_name() {
        return wishlist_name;
    }

    public void setWishlist_name(String wishlist_name) {
        this.wishlist_name = wishlist_name;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }
}
