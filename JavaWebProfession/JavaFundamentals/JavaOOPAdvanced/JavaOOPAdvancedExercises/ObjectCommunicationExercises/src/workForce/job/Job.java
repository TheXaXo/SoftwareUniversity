package workForce.job;

import workForce.Observer;
import workForce.employee.Employee;

public class Job {

    private String name;
    private int hoursOfWorkRequired;
    private Employee employee;
    private Observer observer;

    public Job(String name, int hoursOfWorkRequired,
               Employee employee, Observer observer) {
        this.name = name;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.employee = employee;
        this.observer = observer;
    }

    public void update() {
        this.hoursOfWorkRequired -= this.employee.getWorkHours();

        if (this.hoursOfWorkRequired <= 0) {
            this.observer.notifyObserver(String.format("Job %s done!%n", this.name));
            this.observer.addJobToRemove(this);
        }
    }

    public void status() {
        this.observer.notifyObserver(String.format("Job: %s Hours Remaining: %d%n", this.name, this.hoursOfWorkRequired));
    }
}