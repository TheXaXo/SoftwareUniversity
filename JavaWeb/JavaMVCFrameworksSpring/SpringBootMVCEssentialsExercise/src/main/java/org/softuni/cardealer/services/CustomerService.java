package org.softuni.cardealer.services;

import org.softuni.cardealer.entities.Customer;
import org.softuni.cardealer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAllCustomersSortedByBirthDateAsc() {
        return this.repository.findAllByBirthDateAsc();
    }

    public List<Customer> findAllCustomersSortedByBirthDateDesc() {
        return this.repository.findAllByBirthDateDesc();
    }

    public Customer findCustomerById(long id) {
        return this.repository.findCustomerById(id);
    }

    public void create(Customer customer) {
        this.repository.saveAndFlush(customer);
    }

    public void update(Customer customer) {
        this.repository.saveAndFlush(customer);
    }

    public List<Customer> findAllCustomers() {
        return this.repository.findAll();
    }
}