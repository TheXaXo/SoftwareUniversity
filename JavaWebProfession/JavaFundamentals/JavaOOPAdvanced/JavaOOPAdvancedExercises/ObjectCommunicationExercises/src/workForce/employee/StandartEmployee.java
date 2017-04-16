package workForce.employee;

public class StandartEmployee extends AbstractEmployee {

    private static final int STANDARD_EMPLOYEE_WORK_HOURS = 40;

    public StandartEmployee(String name) {
        super(name, STANDARD_EMPLOYEE_WORK_HOURS);
    }
}