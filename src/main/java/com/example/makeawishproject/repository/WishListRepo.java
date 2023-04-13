package com.example.makeawishproject.repository;

import com.example.makeawishproject.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishListRepo {
    @Autowired
    JdbcTemplate template;

    public List<WishList> fetchWishList(){
        String sql = "SELECT * FROM wishlist";
        RowMapper<WishList> rowMapper = new BeanPropertyRowMapper<>(WishList.class);
        return template.query(sql, rowMapper);
    }

    public void createWishList(WishList u){
        String sql= "Insert into wishlist(wishlist_id, wishlist_name, item_name, item_description) VALUES (?, ?, ?, ?)";
        template.update(sql, u.getWishlist_id(), u.getWishlist_name(), u.getItem_name(), u.getItem_description());
    }
    public List<WishList>  discoveryPage(){
        String sql = "SELECT * FROM wishlist";
        RowMapper<WishList> rowMapper = new BeanPropertyRowMapper<>(WishList.class);
        return template.query(sql, rowMapper);
    }


    public void updateAddItem(int wishlistId, String wishlistName, String itemName, String itemDescription) {
        String sql = "INSERT INTO wishlist(wishlist_id, wishlist_name, item_name, item_description) VALUES (?, ?, ?, ?)";
        template.update(sql, wishlistId, wishlistName, itemName, itemDescription);
    }


    public Boolean deletewishlist(int id){
        String sql = "DELETE FROM wishlist WHERE wishlist_id=?";
        return template.update(sql, id) > 0;
    }

    public Boolean deleteItem(int id){
        String sql = "DELETE FROM wishlist WHERE item_name=? AND item_description=?";
        return template.update(sql, id) > 0;
    }


}
