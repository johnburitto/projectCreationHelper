package com.projectcreationhelper.projectcreationhelper.repository;

import com.projectcreationhelper.projectcreationhelper.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {

}
