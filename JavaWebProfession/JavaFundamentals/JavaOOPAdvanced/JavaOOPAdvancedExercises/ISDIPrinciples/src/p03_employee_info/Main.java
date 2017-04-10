package p03_employee_info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EmployeeInfoProvider employeeInfo = new EmployeeInfoProvider();
        ConsoleFormatter formatter = new ConsoleFormatter();

        ConsoleClient consoleClient = new ConsoleClient(employeeInfo, formatter);
        String criteria = reader.readLine();
        consoleClient.printOutput(criteria);
    }
}