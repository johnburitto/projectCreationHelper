package com.projectcreationhelper.projectcreationhelper.service.impl;

import com.projectcreationhelper.projectcreationhelper.model.WebProject;
import com.projectcreationhelper.projectcreationhelper.service.interfaces.IService;
import org.springframework.stereotype.Service;
import com.projectcreationhelper.projectcreationhelper.repository.IWebProjectRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WebProjectService implements IService<WebProject> {
    private final IWebProjectRepository repository;

    public WebProjectService(IWebProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WebProject> getAll() {
        return repository.findAll();
    }

    @Override
    public WebProject getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public WebProject create(WebProject user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public WebProject update(WebProject user) {
        user.setUpdatedAt(LocalDateTime.now());
        return repository.save(user);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
