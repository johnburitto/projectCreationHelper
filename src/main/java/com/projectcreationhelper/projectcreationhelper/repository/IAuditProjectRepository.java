package com.projectcreationhelper.projectcreationhelper.repository;

import com.projectcreationhelper.projectcreationhelper.model.AuditProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuditProjectRepository extends MongoRepository<AuditProject, String> {

}
