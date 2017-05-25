package workForce;

import workForce.employee.Employee;
import workForce.job.Job;
import workForce.job.JobsList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        Observer observer = new Observer();
        JobsList jobs = new JobsList(observer);
        Map<String, Employee> employees = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Job":
                    jobs.add(new Job(tokens[1], Integer.parseInt(tokens[2]), employees.get(tokens[3]), observer));
                    break;

                case "Pass":
                    jobs.passWeek();
                    break;

                case "Status":
                    jobs.status();
                    break;

                default:
                    try {
                        Class<Employee> employeeClass =
                                (Class<Employee>) Class.forName("workForce.employee." + tokens[0]);
                        Constructor<Employee> constructor = employeeClass.getDeclaredConstructor(String.class);

                        employees.put(tokens[1], constructor.newInstance(tokens[1]));
                    } catch (Exception ex) {
                        System.out.println("There is no such class!");
                    }

                    break;
            }

            command = reader.readLine();
        }
    }
}