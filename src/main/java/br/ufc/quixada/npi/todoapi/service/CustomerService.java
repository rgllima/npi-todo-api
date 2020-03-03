package br.ufc.quixada.npi.todoapi.service;

import br.ufc.quixada.npi.todoapi.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer create(String name, String email, String password);

    Customer findByEmail(String email);

    Customer findById(int id);

    List<Customer> findByAvailable(boolean available);

    List<Customer> findAll();

    Customer update(int id, String name, String email);

    Customer delete(int id);
}
