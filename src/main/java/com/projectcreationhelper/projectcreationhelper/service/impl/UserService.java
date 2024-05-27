package com.projectcreationhelper.projectcreationhelper.service.impl;

import com.projectcreationhelper.projectcreationhelper.model.User;
import com.projectcreationhelper.projectcreationhelper.service.interfaces.IService;
import org.springframework.stereotype.Service;
import com.projectcreationhelper.projectcreationhelper.repository.IUserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService implements IService<User> {
    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public User update(User user) {
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
