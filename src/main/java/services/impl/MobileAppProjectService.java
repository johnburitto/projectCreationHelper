package services.impl;

import models.MobileAppProject;
import org.springframework.stereotype.Service;
import repositories.IMobileAppProjectRepository;
import services.interfaces.IService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MobileAppProjectService implements IService<MobileAppProject> {
    private final IMobileAppProjectRepository repository;

    public MobileAppProjectService(IMobileAppProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MobileAppProject> getAll() {
        return repository.findAll();
    }

    @Override
    public MobileAppProject getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MobileAppProject create(MobileAppProject user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public MobileAppProject update(MobileAppProject user) {
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
