package br.ufc.quixada.npi.todoapi.service.impl;

import br.ufc.quixada.npi.todoapi.model.User;
import br.ufc.quixada.npi.todoapi.respository.UserRepository;
import br.ufc.quixada.npi.todoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
