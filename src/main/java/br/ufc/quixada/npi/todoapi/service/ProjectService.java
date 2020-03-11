package br.ufc.quixada.npi.todoapi.service;

import br.ufc.quixada.npi.todoapi.model.Customer;
import br.ufc.quixada.npi.todoapi.model.Project;

import java.util.List;

public interface ProjectService {

    Project create(String title, String description, String color, Customer customer);

    List<Project> findAllByCustomer(Customer customer);

    Project findById(int id);

    void update(int id, Project project);

    Project delete(int id);
}
