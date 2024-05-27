package com.projectcreationhelper.projectcreationhelper.controller;

import com.projectcreationhelper.projectcreationhelper.model.MobileAppProject;
import org.springframework.web.bind.annotation.*;
import com.projectcreationhelper.projectcreationhelper.service.impl.MobileAppProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mobile-app-projects")
public class MobileAppProjectController {
    private final MobileAppProjectService service;

    public MobileAppProjectController(MobileAppProjectService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<MobileAppProject> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public MobileAppProject getAll(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public MobileAppProject create(@RequestBody MobileAppProject mobileAppProject) {
        return service.create(mobileAppProject);
    }

    @PutMapping("/update/{id}")
    public MobileAppProject update(@PathVariable String id, @RequestBody MobileAppProject mobileAppProject) {
        mobileAppProject.setId(id);

        return service.update(mobileAppProject);
    }

    @DeleteMapping("/update/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
