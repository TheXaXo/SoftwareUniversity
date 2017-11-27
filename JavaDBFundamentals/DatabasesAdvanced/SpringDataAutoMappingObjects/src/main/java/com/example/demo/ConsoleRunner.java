package com.example.demo;

import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner {
    private EmployeeServiceImpl employeeService;

    @Autowired
    public ConsoleRunner(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... strings) throws Exception {
        ModelMapper mapper = new ModelMapper();
//        Employee employee = new Employee("Pesho", "Peshev", new BigDecimal("1.3"), LocalDate.now(), "Tuka", true, null, null);
//        Employee employee2 = new Employee("Pesho2", "Peshev2", new BigDecimal("1.3"), LocalDate.now(), "Tuka", true, employee, null);
//
//        this.employeeService.save(employee);
//        this.employeeService.save(employee2);

//        Employee employee = new Employee("Pesho3", "Peshev3", new BigDecimal("1.3"), LocalDate.of(1899, 1, 1), "Tuka", true, null, null);
//        this.employeeService.save(employee);

        Set<Employee> employeesBornBefore1999 = this.employeeService.findAllByBirthdayBefore1990();
        employeesBornBefore1999.forEach(e -> System.out.println(e.getFirstName()));
    }
}