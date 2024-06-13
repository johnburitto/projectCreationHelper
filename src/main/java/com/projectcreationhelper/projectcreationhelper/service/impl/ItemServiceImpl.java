package com.projectcreationhelper.projectcreationhelper.service.impl;

/*
  @author   george
  @project   spb-base
  @class  ItemService
  @version  1.0.0 
  @since 11.02.24 - 12.28
*/


import com.projectcreationhelper.projectcreationhelper.model.Item;
import com.projectcreationhelper.projectcreationhelper.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl {

    private final ItemRepository repository;

    private List<Item> items = List.of(
            new Item("1", "name1", "000001", "description1"),
            new Item("2", "name2", "000002", "description2"),
            new Item("3", "name3", "000003", "description3")

    );

    @PostConstruct
    void init() {
        repository.deleteAll();
        repository.saveAll(items);
    }

    // CRUD


    public List<Item> getAll() {
        log.info(" -----------  GET ALL ------------------");
        return repository.findAll();
    }


    public Item getById(String id) {
        log.info(" request for id = " + id);
        return repository.findById(id).orElse(null);
    }


    public Item create(Item item) {
        log.info(" request for creation = " + item);
        return repository.save(item);
    }


    public void delete(String id) {
        log.info(" delete id = " + id);
        repository.deleteById(id);
    }



}
