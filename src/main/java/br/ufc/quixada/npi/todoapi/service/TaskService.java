package br.ufc.quixada.npi.todoapi.service;

import br.ufc.quixada.npi.todoapi.model.Project;
import br.ufc.quixada.npi.todoapi.model.Task;

import java.util.List;

public interface TaskService {

    Task create(String title, String description, Project project, String date, String time);

    Task findById(int id);

    List<Task> findAll();

    List<Task> findByProject(int p_id);

    void update(int id, Task task);

    Task delete(int id);
}
