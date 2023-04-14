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
        List<WishList> wishLists = template.query(sql, rowMapper);
        for (WishList w:wishLists) {
            int id = w.getWishlist_id();
            String sql2 = "SELECT COUNT(item_id) FROM item WHERE wishlist_id = ?";
            int count = template.queryForObject(sql2, Integer.class,id);
            w.setCount(count);
        }
        return wishLists;
    }
    public List<WishList> discoveryPage(){
        String sql = "SELECT * FROM wishlist";
        RowMapper<WishList> rowMapper = new BeanPropertyRowMapper<>(WishList.class);
        return template.query(sql, rowMapper);
    }


    public void createWishList(WishList u){
        String sql= "Insert into wishlist(wishlist_id, wishlist_name,wishlist_description) VALUES (?, ?, ?)";
        template.update(sql, u.getWishlist_id(), u.getWishlist_name(), u.getWishlist_description());
    }
    
    
    public Boolean deletewishlist(int id){
        String sql = "DELETE FROM wishlist WHERE wishlist_id=?";
        return template.update(sql, id) > 0;
    }




}
