package br.ufc.quixada.npi.todoapi.controller;

import br.ufc.quixada.npi.todoapi.config.JwtTokenProvider;
import br.ufc.quixada.npi.todoapi.model.Customer;
import br.ufc.quixada.npi.todoapi.model.Project;
import br.ufc.quixada.npi.todoapi.respository.CustomerRepository;
import br.ufc.quixada.npi.todoapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("")
    public ResponseEntity<Project> create(@RequestBody Project body, ServletRequest request) {
        Customer customer = customerRepository.findByEmail(request.getAttribute("username").toString());

        return ResponseEntity.ok(projectService.create(body.getTitle(), body.getDescription(), body.getColor(), customer));
    }

    @GetMapping("")
    public ResponseEntity<List<Project>> findAllByCustomer(ServletRequest request) {
        Customer customer = customerRepository.findByEmail(request.getAttribute("username").toString());

        return  ResponseEntity.ok(projectService.findAllByCustomer(customer));
    }

    @GetMapping("{id}")
    public ResponseEntity<Project> find(@PathVariable Integer id) {
        return ResponseEntity.ok(projectService.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Project> update(@RequestBody Project project, @PathVariable Integer id) {
        //TODO Informar quando não ocorrer a atualização
        projectService.update(id, project);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Project> delete(@PathVariable Integer id)  {
        return ResponseEntity.ok(projectService.delete(id));
    }
}
