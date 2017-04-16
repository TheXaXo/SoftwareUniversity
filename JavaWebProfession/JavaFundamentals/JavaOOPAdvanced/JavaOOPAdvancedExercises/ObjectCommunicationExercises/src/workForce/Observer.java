package workForce;

import workForce.job.Job;

import java.util.ArrayList;
import java.util.List;

public class Observer {

    private List<Job> jobsToRemove;

    public Observer() {
        this.jobsToRemove = new ArrayList<>();
    }

    public void notifyObserver(String message) {
        System.out.print(message);
    }

    public List<Job> getJobsToRemove() {
        List<Job> jobsToReturn = new ArrayList<>(this.jobsToRemove);
        this.jobsToRemove.clear();

        return jobsToReturn;
    }

    public void addJobToRemove(Job job) {
        this.jobsToRemove.add(job);
    }
}