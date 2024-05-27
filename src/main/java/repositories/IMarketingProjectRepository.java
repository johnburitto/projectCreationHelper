package repositories;

import models.MarketingProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarketingProjectRepository extends MongoRepository<MarketingProject, String> {

}
