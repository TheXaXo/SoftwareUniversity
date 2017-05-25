import P04_DetailPrinter.DetailsPrinter;
import P04_DetailPrinter.Employee;
import P04_DetailPrinter.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Gosho"));
        employeeList.add(new Manager("Pesho",
                new ArrayList<>(Arrays.asList("Doc1", "Doc2"))));

        DetailsPrinter printer = new DetailsPrinter(employeeList);
        printer.printDetails();
    }
}