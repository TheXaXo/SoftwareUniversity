package workForce.employee;

public abstract class AbstractEmployee implements Employee {

    private String name;
    private int workHours;

    public AbstractEmployee(String name, int workHours) {
        this.name = name;
        this.workHours = workHours;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWorkHours() {
        return this.workHours;
    }
}