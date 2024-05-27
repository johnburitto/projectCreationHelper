package controllers;

import models.MarketingProject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.impl.MarketingProjectService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/marketing-projects")
public class MarketingProjectController {
    private final MarketingProjectService service;

    public MarketingProjectController(MarketingProjectService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<MarketingProject> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public MarketingProject getAll(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public MarketingProject create(@RequestBody MarketingProject marketingProject) {
        return service.create(marketingProject);
    }

    @PutMapping("/update/{id}")
    public MarketingProject update(@PathVariable String id, @RequestBody MarketingProject marketingProject) {
        marketingProject.setId(id);

        return service.update(marketingProject);
    }

    @DeleteMapping("/update/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
