package br.ufc.quixada.npi.todoapi.service.impl;

import br.ufc.quixada.npi.todoapi.model.Customer;
import br.ufc.quixada.npi.todoapi.respository.CustomerRepository;
import br.ufc.quixada.npi.todoapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer create(String name, String email, String password) {
        Customer customer = new Customer();

        customer.setName(name);
        customer.setPassword(password);
        customer.setEmail(email);
        customer.setAvailable(true);

        return customerRepository.save(customer);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findByAvailable(boolean available) {
        return customerRepository.findByAvailable(available);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void update(int id, Customer customer) {
        if (!customer.getName().isEmpty()) {
            customerRepository.updateName(id, customer.getName());
        }

        if (!customer.getPassword().isEmpty()) {
            String password = new BCryptPasswordEncoder(12).encode(customer.getPassword());
            customerRepository.updatePassword(id, password);
        }
    }

    @Override
    public Customer delete(int id) {
        Customer customer = customerRepository.findById(id);
        customerRepository.delete(customer);
        return  customer;
    }
}
