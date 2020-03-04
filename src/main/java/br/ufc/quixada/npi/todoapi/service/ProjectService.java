package br.ufc.quixada.npi.todoapi.service;

import br.ufc.quixada.npi.todoapi.model.Project;

import java.util.List;

public interface ProjectService {

    Project create(String title, String description, String color);

    List<Project> findAll();

    Project findById(int id);

    void update(int id, Project project);

    Project delete(int id);
}
