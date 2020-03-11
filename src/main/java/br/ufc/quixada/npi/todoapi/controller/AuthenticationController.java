package br.ufc.quixada.npi.todoapi.controller;

import br.ufc.quixada.npi.todoapi.config.JwtTokenProvider;
import br.ufc.quixada.npi.todoapi.model.Customer;
import br.ufc.quixada.npi.todoapi.respository.CustomerRepository;
import br.ufc.quixada.npi.todoapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<Object> signin(@RequestBody AuthenticationRequest data) {

        try {
            String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username, new ArrayList());
            Customer customer = customerRepository.findByEmail(username);
            Map<Object, Object> model = new HashMap<>();
            model.put("username", customer.getName());
            model.put("token", "Bearer " + token);
            return ok(model);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Usuário e/ou senha inválidos");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> signup(@RequestBody Customer body) {

        String password = new BCryptPasswordEncoder(12).encode(body.getPassword());

        Customer customer = customerService.create(body.getName(), body.getEmail(), password);

        String token = jwtTokenProvider.createToken(customer.getEmail(), new ArrayList());

        Map<Object, Object> model = new HashMap<>();
        model.put("username", customer.getName());
        model.put("token", "Bearer " + token);
        return ok(model);
    }

}
