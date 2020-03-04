package br.ufc.quixada.npi.todoapi.service.impl;

import br.ufc.quixada.npi.todoapi.model.Project;
import br.ufc.quixada.npi.todoapi.model.Task;
import br.ufc.quixada.npi.todoapi.respository.TaskRepository;
import br.ufc.quixada.npi.todoapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task create(String title, String description, Project project, String date, String time) {
        Task task = new Task();

        task.setTitle(title);
        task.setDescription(description);
        task.setProject(project);
        task.setDate(date);
        task.setTime(time);
        task.setChecked(false);
        task.setCreatedAt(new Date().toString());

        return taskRepository.save(task);
    }

    @Override
    public Task findById(int id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findByProject(int p_id) {
        return taskRepository.findByProject(p_id);
    }

    @Override
    public void update(int id, Task task) {
        if (!task.getTitle().isEmpty()) {
            taskRepository.updateTitle(id, task.getTitle());
        }

        if (!task.getDescription().isEmpty()) {
            taskRepository.updateDescription(id, task.getDescription());
        }

//        if (task.getProject() != null) {
//            taskRepository.updateProject(id, task.getProject());
//        }

        if (!task.getDate().isEmpty()) {
            taskRepository.updateDate(id, task.getDate());
        }

        if (!task.getTime().isEmpty()) {
            taskRepository.updateTime(id, task.getTime());
        }
    }

    @Override
    public void updateChecked(int id, boolean value) {
        taskRepository.updateChecked(id, value);
    }

    @Override
    public Task delete(int id) {
        Task task = taskRepository.findById(id);
        taskRepository.delete(task);
        return task;
    }
}
