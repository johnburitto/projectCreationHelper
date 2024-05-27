package com.projectcreationhelper.projectcreationhelper.service.impl;

import com.projectcreationhelper.projectcreationhelper.model.MarketingProject;
import com.projectcreationhelper.projectcreationhelper.service.interfaces.IService;
import org.springframework.stereotype.Service;
import com.projectcreationhelper.projectcreationhelper.repository.IMarketingProjectRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MarketingProjectService implements IService<MarketingProject> {
    private final IMarketingProjectRepository repository;

    public MarketingProjectService(IMarketingProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MarketingProject> getAll() {
        return repository.findAll();
    }

    @Override
    public MarketingProject getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MarketingProject create(MarketingProject user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public MarketingProject update(MarketingProject user) {
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
