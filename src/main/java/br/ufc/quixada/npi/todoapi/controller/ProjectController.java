package br.ufc.quixada.npi.todoapi.controller;

import br.ufc.quixada.npi.todoapi.model.Project;
import br.ufc.quixada.npi.todoapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public ResponseEntity<List<Project>> findAll() {
        return  ResponseEntity.ok(projectService.findAll());
    }
}
