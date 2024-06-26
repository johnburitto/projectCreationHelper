package com.projectcreationhelper.projectcreationhelper.controller;

import com.projectcreationhelper.projectcreationhelper.model.AuditProject;
import org.springframework.web.bind.annotation.*;
import com.projectcreationhelper.projectcreationhelper.service.impl.AuditProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/audit-projects")
public class AuditProjectController {
    private final AuditProjectService service;

    public AuditProjectController(AuditProjectService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<AuditProject> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public AuditProject getAll(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public AuditProject create(@RequestBody AuditProject auditProject) {
        return service.create(auditProject);
    }

    @PutMapping("/update/{id}")
    public AuditProject update(@PathVariable String id, @RequestBody AuditProject auditProject) {
        auditProject.setId(id);

        return service.update(auditProject);
    }

    @DeleteMapping("/update/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
