package br.ufc.quixada.npi.todoapi.controller;

import br.ufc.quixada.npi.todoapi.model.Customer;
import br.ufc.quixada.npi.todoapi.model.Task;
import br.ufc.quixada.npi.todoapi.respository.CustomerRepository;
import br.ufc.quixada.npi.todoapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("")
    public ResponseEntity<Task> create(@RequestBody Task body, ServletRequest request) {
        Customer customer = customerRepository.findByEmail(request.getAttribute("username").toString());

        return ResponseEntity.ok(taskService.create(body.getTitle(), body.getDescription(), body.getProject(), body.getDate(), body.getTime(),customer));
    }

    @GetMapping("")
    public ResponseEntity<List<Task>> findAll(ServletRequest request) {
        Customer customer = customerRepository.findByEmail(request.getAttribute("username").toString());

        return  ResponseEntity.ok(taskService.findAllByCustomer(customer));
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> find(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<List<Task>> findByProject(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.findByProject(id));
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
