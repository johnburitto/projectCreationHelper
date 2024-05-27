package services.impl;

import models.NewsProject;
import org.springframework.stereotype.Service;
import repositories.INewsProjectRepository;
import services.interfaces.IService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsProjectService implements IService<NewsProject> {
    private final INewsProjectRepository repository;

    public NewsProjectService(INewsProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<NewsProject> getAll() {
        return repository.findAll();
    }

    @Override
    public NewsProject getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public NewsProject create(NewsProject user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public NewsProject update(NewsProject user) {
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
