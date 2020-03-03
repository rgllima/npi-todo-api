package br.ufc.quixada.npi.todoapi.controller;

import br.ufc.quixada.npi.todoapi.exception.StandardError;
import br.ufc.quixada.npi.todoapi.model.Customer;
import br.ufc.quixada.npi.todoapi.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping("/users")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> findAll() {
        return  ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> find(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Customer>> findAvailable() {
        return ResponseEntity.ok(customerService.findByAvailable(true));
    }

    @GetMapping("/unavailable")
    public ResponseEntity<List<Customer>> findUnavailable() {
        return ResponseEntity.ok(customerService.findByAvailable(false));
    }

    @PostMapping("")
    public ResponseEntity<Customer> create(@RequestBody Customer body) {
        //FIXME Rever como fazer a autenticação do usuário
        String password = new BCryptPasswordEncoder(12).encode(body.getPassword());
        return ResponseEntity.ok(customerService.create(body.getName(), body.getEmail(), password));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Customer> delete(@PathVariable Integer id)  {
        Customer customer = customerService.findById(id);

        if (customer.isEnabled()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(customerService.delete(id));
    }

    // @PutMapping("{id}")
    /*public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {

    }*/

}
