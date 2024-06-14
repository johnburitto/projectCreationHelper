package com.projectcreationhelper.projectcreationhelper.repository;
/*
  @author   Olga Bosovik
  @project   project-creation-helper
  @class  Repository
  @version  1.0.0
  @since 01.05.24 - 18.22
*/


import com.projectcreationhelper.projectcreationhelper.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
