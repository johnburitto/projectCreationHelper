package controllers;

import models.MobileAppProject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.impl.MobileAppProjectService;

import java.util.List;

@Controller
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
