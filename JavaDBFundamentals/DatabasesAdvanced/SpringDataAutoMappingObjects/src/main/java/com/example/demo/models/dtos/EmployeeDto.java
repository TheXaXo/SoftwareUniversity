package com.example.demo.models.dtos;

import java.math.BigDecimal;

public class EmployeeDto extends PersonDto {
    private BigDecimal salary;

    public EmployeeDto() {
    }

    public EmployeeDto(String firstName, String lastName, BigDecimal salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}