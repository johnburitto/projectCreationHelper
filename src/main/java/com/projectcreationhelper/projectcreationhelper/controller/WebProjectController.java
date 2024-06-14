package com.projectcreationhelper.projectcreationhelper.controller;

import com.projectcreationhelper.projectcreationhelper.model.WebProject;
import org.springframework.web.bind.annotation.*;
import com.projectcreationhelper.projectcreationhelper.service.impl.WebProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/web-projects")
@CrossOrigin("*")
public class WebProjectController {
    private final WebProjectService service;

    public WebProjectController(WebProjectService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<WebProject> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public WebProject getAll(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public WebProject create(@RequestBody WebProject webProject) {
        return service.create(webProject);
    }

    @PutMapping("/update/{id}")
    public WebProject update(@PathVariable String id, @RequestBody WebProject webProject) {
        webProject.setId(id);
        return service.update(webProject);
    }

    @DeleteMapping("/update/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
