package com.jdbcspring.jdbcspring.controller;


import com.jdbcspring.jdbcspring.model.Item;

import com.jdbcspring.jdbcspring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping
    public List<Item> getListAll(){
        List<Item> list = repository.getAllItems();

        return  list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable int id){
        if (id < 1)
            return ResponseEntity.noContent().build();

        Item item = repository.getItem(id);

        if (item == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id){
        if (id < 1)
            return ResponseEntity.noContent().build();

        repository.deleteItem(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item){
        if (item == null)
            return ResponseEntity.noContent().build();

        repository.addItem(item.getId(), item.getName(), item.getCategory());

        return ResponseEntity.ok(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item item){
        if ( id < 1)
            return ResponseEntity.noContent().build();

        if (item == null)
            return ResponseEntity.noContent().build();

        repository.updateItem(id, item.getName(), item.getCategory());

        return ResponseEntity.ok(item);
    }

}
