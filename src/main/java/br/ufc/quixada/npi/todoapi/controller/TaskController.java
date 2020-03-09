package br.ufc.quixada.npi.todoapi.controller;

import br.ufc.quixada.npi.todoapi.model.Task;
import br.ufc.quixada.npi.todoapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("")
    public ResponseEntity<Task> create(@RequestBody Task body) {
        return ResponseEntity.ok(taskService.create(body.getTitle(), body.getDescription(), body.getProject(), body.getDate(), body.getTime()));
    }

    @GetMapping("")
    public ResponseEntity<List<Task>> findAll() {
        return  ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> find(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> update(@RequestBody Task task, @PathVariable Integer id) {
        //TODO Informar quando não ocorrer a atualização
        taskService.update(id, task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Task> delete(@PathVariable Integer id)  {
        return ResponseEntity.ok(taskService.delete(id));
    }

}
