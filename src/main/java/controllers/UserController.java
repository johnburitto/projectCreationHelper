package controllers;

import models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.impl.UserService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {
    final
    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public User getAll(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        user.setId(id);

        return service.update(user);
    }

    @DeleteMapping("/update/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
