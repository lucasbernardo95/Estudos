package com.jdbcspring.jdbcspring.repository;

import com.jdbcspring.jdbcspring.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Item> getAllItems(){
        List<Item> items = template.query("SELECT id, name, category from item", (result, rowNum)
                -> new Item(result.getInt("id"), result.getString("name"), result.getString("category")));
        return items;
    }

    public Item getItem(int idItem){
        String query = "SELECT * FROM item WHERE id=?";
        Item item = template.queryForObject(query, new Object[]{idItem}, new BeanPropertyRowMapper<>(Item.class));
        return item;
    }

    public int addItem(int id, String name, String category){
        String query = "INSERT INTO item(id, name, category) VALUES(?, ?, ?)";
        return template.update(query, id, name, category);
    }

    public int updateItem(int id, String name, String category){
        String query = "UPDATE item SET name = ?, category = ? WHERE id = ?";
        return template.update(query, name, category, id);
    }

    public int deleteItem(int id){
        String query = "DELETE FROM item WHERE id = ?";
        return template.update(query, id);
    }

}