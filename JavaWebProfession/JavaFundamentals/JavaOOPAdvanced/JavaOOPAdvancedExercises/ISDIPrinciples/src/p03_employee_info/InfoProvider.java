package p03_employee_info;

public interface InfoProvider {

    Iterable<Employee> getEmployees(String criteria);
}
