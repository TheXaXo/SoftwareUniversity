package workForce.job;

import workForce.Observer;

import java.util.ArrayList;

public class JobsList extends ArrayList<Job> {

    private Observer eventListener;

    public JobsList(Observer eventListener) {
        this.eventListener = eventListener;
    }

    public void passWeek() {
        for (Job job : this) {
            job.update();
        }

        this.removeAll(this.eventListener.getJobsToRemove());
    }

    public void status() {
        for (Job job : this) {
            job.status();
        }
    }
}