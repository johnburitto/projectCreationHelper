package com.projectcreationhelper.projectcreationhelper.controller;
/*
  @author   Olga Bosovik
  @project   spb-base
  @class  ItemController
  @version  1.0.0 
  @since 11.02.24 - 12.40
*/


import com.projectcreationhelper.projectcreationhelper.model.Item;
import com.projectcreationhelper.projectcreationhelper.service.impl.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ItemController {

    private final ItemServiceImpl service;

    @GetMapping("")
    public List<Item> fetchAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Item fetchById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Item insert(@RequestBody Item item) {
        return service.create(item);
    }

    @DeleteMapping("/{id}")
    public void eraseById(@PathVariable String id) {
         service.delete(id);
    }


}
