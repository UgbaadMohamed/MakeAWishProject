package com.example.makeawishproject.repository;
import com.example.makeawishproject.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public boolean find(int wishlistId) {
        String sql = "SELECT 1 FROM wishlist WHERE wishlist_id = ?";
        return template.queryForObject(sql, Integer.class, wishlistId) != null;
    }

    public List <WishList> findWishlist(int wishlist_id) {
        String sql = "SELECT w.wishlist_name, i.item_name, i.item_description, w.wishlist_id\n" +
                "FROM wishlist w \n" +
                "JOIN item i ON w.wishlist_id = i.wishlist_id \n" +
                "WHERE w.wishlist_id = ?";
        RowMapper<WishList> rowMapper = new BeanPropertyRowMapper<>(WishList.class);
       return template.query(sql, rowMapper, wishlist_id);
       /* try {
            WishList wishList = template.queryForObject(sql, rowMapper, wishlist_id);
            return wishList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }*/
    }






}
