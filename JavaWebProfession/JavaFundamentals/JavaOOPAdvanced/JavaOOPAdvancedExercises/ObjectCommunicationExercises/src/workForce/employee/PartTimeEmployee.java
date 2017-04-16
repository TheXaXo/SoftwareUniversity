package workForce.employee;

public class PartTimeEmployee extends AbstractEmployee {

    private static final int PART_TIME_EMPLOYEE_WORK_HOURS = 20;

    public PartTimeEmployee(String name) {
        super(name, PART_TIME_EMPLOYEE_WORK_HOURS);
    }
}