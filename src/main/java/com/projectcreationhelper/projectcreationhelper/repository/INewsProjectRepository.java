package com.projectcreationhelper.projectcreationhelper.repository;

import com.projectcreationhelper.projectcreationhelper.model.NewsProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INewsProjectRepository extends MongoRepository<NewsProject, String> {

}
