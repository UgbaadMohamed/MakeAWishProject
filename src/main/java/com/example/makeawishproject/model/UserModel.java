package com.example.makeawishproject.model;
public class UserModel {

    private int user_id;
    private String first_name;
    private String last_name;
    private String address;
    private String username;
    private String user_password;

    private int wishlist_id;

    public UserModel() {

    }

    public UserModel(int user_id, String first_name, String last_name, String address, String username, String user_password) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.username = username;
        this.user_password = user_password;
    }


    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
