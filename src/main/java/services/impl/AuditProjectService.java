package services.impl;

import models.AuditProject;
import org.springframework.stereotype.Service;
import repositories.IAuditProjectRepository;
import services.interfaces.IService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditProjectService implements IService<AuditProject> {
    private final IAuditProjectRepository repository;

    public AuditProjectService(IAuditProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AuditProject> getAll() {
        return repository.findAll();
    }

    @Override
    public AuditProject getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AuditProject create(AuditProject user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public AuditProject update(AuditProject user) {
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
