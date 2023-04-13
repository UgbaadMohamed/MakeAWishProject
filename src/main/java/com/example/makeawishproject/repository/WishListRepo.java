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

    public void createWishList(WishList w) {
        String sql = "INSERT INTO wishlist (wishlist_id, wishlist_name, wishlist_description) VALUES (?, ?, ?)";
        template.update(sql, w.getWishlist_id(), w.getWishlist_name(), w.getWishlist_description());
    }
    public List<WishList> discoveryPage(){
        String sql = "SELECT * FROM wishlist";
        RowMapper<WishList> rowMapper = new BeanPropertyRowMapper<>(WishList.class);
        return template.query(sql, rowMapper);
    }

    public List <WishList> findWishlist(int wishlist_id) {
        String sql = "SELECT w.wishlist_name, i.item_name, i.item_description, w.wishlist_id\n" +
                "FROM wishlist w \n" +
                "JOIN item i ON w.wishlist_id = i.wishlist_id \n" +
                "WHERE w.wishlist_id = ?";
        RowMapper<WishList> rowMapper = new BeanPropertyRowMapper<>(WishList.class);
        return template.query(sql, rowMapper, wishlist_id);
    }



}
