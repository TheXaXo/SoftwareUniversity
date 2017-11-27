package com.example.demo.services;

import com.example.demo.models.Employee;

import java.util.Set;

public interface EmployeeService {
    Set<Employee> findAllByBirthdayBefore1990();

    void save(Employee employee);

    Employee findById(int id);
}