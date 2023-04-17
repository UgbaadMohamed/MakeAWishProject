package com.example.makeawishproject.repository;

import com.example.makeawishproject.model.Item;
import com.example.makeawishproject.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ItemRepo {
    @Autowired
    JdbcTemplate template;

    public List<Item> fetchItems(){
        String sql = "SELECT DISTINCT item_id, item_name, item_description, w.wishlist_id\n" +
                "FROM item i JOIN wishlist w ON i.wishlist_id = w.wishlist_id";
        RowMapper<Item> rowMapper = new BeanPropertyRowMapper<>(Item.class);
        return template.query(sql, rowMapper);
    }

    public void addItem(Item i) {
        String sql = "INSERT INTO item (item_id, item_name, item_description, wishlist_id, reserved) VALUES (?, ?," +
                " ?, ?, ?)";
        template.update(sql, i.getItem_id(), i.getItem_name(), i.getItem_description(), i.getWishlist_id(), 0);
    }

    public List<Item> viewWishlist(int wishlist_id) {
        String sql = "\n" +
                "SELECT DISTINCT item_id, wishlist_description, item_name, item_description, w.wishlist_id\n" +
                "FROM item i\n" +
                "\tJOIN wishlist w ON i.wishlist_id = w.wishlist_id\n" +
                " WHERE w.wishlist_id = ?; ";
        RowMapper<Item> rowMapper = new BeanPropertyRowMapper<>(Item.class);
        return template.query(sql, rowMapper, wishlist_id);
    }

    public void reserveItem(Item i){
         String sql = "UPDATE item SET reserved = ? WHERE item_id = ?";
         template.update(sql, 1, i.getItem_id());
    }

    public Boolean deleteItem(int item_id){
        String sql = "DELETE FROM item WHERE item_id = ?";
        return template.update(sql, item_id) > 0;
    }

    public Item findPersonById(int id){
        String sql="SELECT * FROM item WHERE item_id = ?";
        RowMapper<Item> rowMapper= new BeanPropertyRowMapper<>(Item.class);
        Item i= template.queryForObject(sql, rowMapper, id);
        return i;
    }

    public void editItem(int item_id, Item i){
        String sql="UPDATE item SET item_name = ?, item_description = ? WHERE item_id = ?";
        template.update(sql, i.getItem_name(), i.getItem_description(), i.getItem_id());

    }
}
