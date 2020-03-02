package br.ufc.quixada.npi.todoapi.controller;

import br.ufc.quixada.npi.todoapi.model.User;
import br.ufc.quixada.npi.todoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> findAll() {
        return  ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<List<User>> find(@PathVariable Integer id) {
        // Busca usuário pelo id e retornar usuário...
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public ResponseEntity<List<User>> create(@RequestBody User usuario) {
        // Cadastrar usuário e retornar usuário cadastrado...
        return ResponseEntity.ok().build();
    }

    //@DeleteMapping("{id}")
    //TODO: excluir usuário

    // @PutMapping("{id}")
    /*public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {

    }*/

}
