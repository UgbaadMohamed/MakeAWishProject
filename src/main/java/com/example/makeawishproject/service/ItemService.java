package com.example.makeawishproject.service;

import com.example.makeawishproject.model.Item;
import com.example.makeawishproject.model.WishList;
import com.example.makeawishproject.repository.ItemRepo;
import com.example.makeawishproject.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService {
    @Autowired
    ItemRepo itemRepo;

    public List<Item> fetchItems(){
        return itemRepo.fetchItems();
    }


    public void addItem(Item i) {
        itemRepo.addItem(i);
    }

    public Boolean deleteItem(int id){
        return itemRepo.deleteItem(id);
    }
}
