package com.projectcreationhelper.projectcreationhelper.repository;

import com.projectcreationhelper.projectcreationhelper.model.WebProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWebProjectRepository extends MongoRepository<WebProject, String> {

}

