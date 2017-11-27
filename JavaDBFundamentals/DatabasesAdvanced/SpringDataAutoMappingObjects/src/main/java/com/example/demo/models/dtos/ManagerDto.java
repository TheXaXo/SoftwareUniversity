package com.example.demo.models.dtos;

import com.example.demo.models.Employee;

import java.util.Set;

public class ManagerDto extends PersonDto {
    private Set<Employee> employees;

    public ManagerDto() {
    }

    public ManagerDto(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}