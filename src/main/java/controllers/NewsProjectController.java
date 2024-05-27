package controllers;

import models.NewsProject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.impl.NewsProjectService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/news-projects")
public class NewsProjectController {
    private final NewsProjectService service;

    public NewsProjectController(NewsProjectService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<NewsProject> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public NewsProject getAll(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public NewsProject create(@RequestBody NewsProject newsProject) {
        return service.create(newsProject);
    }

    @PutMapping("/update/{id}")
    public NewsProject update(@PathVariable String id, @RequestBody NewsProject newsProject) {
        newsProject.setId(id);

        return service.update(newsProject);
    }

    @DeleteMapping("/update/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
