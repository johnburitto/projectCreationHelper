package repositories;

import models.AuditProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuditProjectRepository extends MongoRepository<AuditProject, String> {

}
