package br.ufc.quixada.npi.todoapi.service.impl;

import br.ufc.quixada.npi.todoapi.model.Project;
import br.ufc.quixada.npi.todoapi.respository.ProjectRepository;
import br.ufc.quixada.npi.todoapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project create(String title, String description, String color) {
        Project project = new Project();

        project.setTitle(title);
        project.setDescription(description);
        project.setColor(color);
        project.setCreatedAt(new Date().toString());

        return projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(int id) {
        return projectRepository.findById(id);
    }

    @Override
    public void update(int id, Project project) {
        if (!project.getTitle().isEmpty()) {
            projectRepository.updateTitle(id, project.getTitle());
        }

        if (!project.getDescription().isEmpty()) {
            projectRepository.updateDescription(id, project.getDescription());
        }

        if (!project.getColor().isEmpty()) {
            projectRepository.updateColor(id, project.getColor());
        }
    }

    @Override
    public Project delete(int id) {
        Project project = projectRepository.findById(id);
        projectRepository.delete(project);
        return project;
    }
}
