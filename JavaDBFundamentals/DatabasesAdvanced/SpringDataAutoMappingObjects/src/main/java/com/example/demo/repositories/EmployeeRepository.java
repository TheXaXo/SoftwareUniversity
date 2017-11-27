package com.example.demo.repositories;

import com.example.demo.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Set<Employee> findAllByBirthdayBefore(LocalDate date);
}