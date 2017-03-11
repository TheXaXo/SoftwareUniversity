package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayList<Department> departments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String personName = tokens[0];
            double personSalary = Double.parseDouble(tokens[1]);
            String personPosition = tokens[2];
            String department = tokens[3];

            Employee newEmployee = new Employee(personName, personSalary, personPosition, department);

            if (tokens.length > 4) {
                String element = tokens[4];

                if (checkIfIsNumber(element)) {
                    newEmployee.setAge(Integer.parseInt(element));
                } else {
                    newEmployee.setEmail(element);
                }
            }

            if (tokens.length > 5) {
                String element = tokens[5];

                if (checkIfIsNumber(element)) {
                    newEmployee.setAge(Integer.parseInt(element));
                } else {
                    newEmployee.setEmail(element);
                }
            }

            if (departments.stream().noneMatch(dep -> dep.getName().equals(department))) {
                Department newDepartment = new Department(department);

                newDepartment.getEmployees().add(newEmployee);
                departments.add(newDepartment);
            } else {
                Optional<Department> departmentToAddTo = departments.stream().filter(dep -> dep.getName().equals(department)).findFirst();

                if (departmentToAddTo.isPresent()) {
                    departmentToAddTo.get().getEmployees().add(newEmployee);
                }
            }
        }

        departments.stream()
                .sorted(Comparator.<Department>comparingDouble(dep -> dep.getEmployees().stream().mapToDouble(emp -> emp.getSalary()).average().orElse(0))
                        .reversed())
                .limit(1)
                .forEach(dep -> {
                    System.out.println("Highest Average Salary: " + dep.getName());

                    dep.getEmployees().stream()
                            .sorted(Comparator.<Employee>comparingDouble(emp -> emp.getSalary())
                                    .reversed())
                            .forEach(emp -> System.out.printf("%s %.2f %s %d%n",
                                    emp.getName(), emp.getSalary(), emp.getEmail(), emp.getAge()));
                });
    }

    public static boolean checkIfIsNumber(String element) {
        try {
            Integer.parseInt(element);
        } catch (Exception ex) {
            return false;
        }

        return true;
    }
}