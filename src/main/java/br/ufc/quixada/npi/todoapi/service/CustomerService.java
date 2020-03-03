package br.ufc.quixada.npi.todoapi.service;

import br.ufc.quixada.npi.todoapi.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer findByEmail(String email);

    List<Customer> findAll();
}
