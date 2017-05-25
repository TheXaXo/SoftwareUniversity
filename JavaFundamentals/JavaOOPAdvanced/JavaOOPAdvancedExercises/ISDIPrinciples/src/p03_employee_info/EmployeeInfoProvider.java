package p03_employee_info;

import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider {

    private EmployeeDatabase database;

    public EmployeeInfoProvider() {
        this.database = new EmployeeDatabase();
    }

    public Iterable<Employee> getEmployees(String criteria) {
        switch (criteria) {
            case "name":
                return this.database.readEmployees().stream()
                        .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                        .collect(Collectors.toList());
            case "salary":
                return this.database.readEmployees().stream()
                        .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                        .collect(Collectors.toList());
        }
        return null;
    }
}