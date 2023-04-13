package com.example.makeawishproject.model;

public class WishList {

    private String wishlist_name;
    private String wishlist_description;
    private int wishlist_id;
    private String item_name;
    private String item_description;


    public WishList(){
    }

    public WishList(int wishlist_id,String wishlist_name, String wishlist_description)  {
        this.wishlist_id = wishlist_id;
        this.wishlist_name = wishlist_name;
        this.wishlist_description = wishlist_description;
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

    public String getWishlist_description()
    {
        return wishlist_description;
    }

    public void setWishlist_description(String wishlist_description)
    {
        this.wishlist_description = wishlist_description;
    }

    public String getItem_name()
    {
        return item_name;
    }

    public void setItem_name(String item_name)
    {
        this.item_name = item_name;
    }

    public String getItem_description()
    {
        return item_description;
    }

    public void setItem_description(String item_description)
    {
        this.item_description = item_description;
    }


}
