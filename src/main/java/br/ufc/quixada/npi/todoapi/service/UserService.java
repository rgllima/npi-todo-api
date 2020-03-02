package br.ufc.quixada.npi.todoapi.service;

import br.ufc.quixada.npi.todoapi.model.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email);

    List<User> findAll();
}
