package repositories;

import models.MobileAppProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMobileAppProjectRepository extends MongoRepository<MobileAppProject, String> {

}
