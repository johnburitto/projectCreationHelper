package repositories;

import models.NewsProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INewsProjectRepository extends MongoRepository<NewsProject, String> {

}
