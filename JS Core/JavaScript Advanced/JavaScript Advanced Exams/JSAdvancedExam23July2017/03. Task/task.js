class Task {
    constructor(title, deadline) {
        this.title = title;
        this.deadline = deadline;
        this.status = "Open";
    }

    get deadline() {
        return this._deadline;
    }

    set deadline(deadline) {
        if (!(deadline instanceof Date)) {
            throw new Error("The deadline object is not of class Date");
        }

        if (deadline < Date.now()) {
            throw new Error("The date you are trying to set is in the past");
        }

        this._deadline = deadline;
    }

    get isOverdue() {
        return this.deadline < Date.now() && (this.status !== "Complete")
    }

    static comparator(a, b) {
        if (a.isOverdue === true && b.isOverdue === false) {
            return -1;
        } else if (a.isOverdue === false && b.isOverdue === true) {
            return 1;
        } else if (a.isOverdue === true && b.isOverdue === true) {
            if (a.deadline > b.deadline) {
                return 1;
            } else if (a.deadline === b.deadline) {
                return 0;
            } else {
                return -1;
            }
        }

        let statuses = ["Complete", "Open", "In Progress"];

        if (statuses.indexOf(a.status) > statuses.indexOf(b.status)) {
            return -1;
        } else if (statuses.indexOf(a.status) < statuses.indexOf(b.status)) {
            return 1;
        }

        if (a.deadline > b.deadline) {
            return 1;
        } else if (a.deadline === b.deadline) {
            return 0;
        } else {
            return -1;
        }
    }

    toString() {
        let icon = "";

        if (this.isOverdue) {
            icon = "\u26A0";
            return `[${icon}] ${this.title} (overdue)`;
        }

        switch (this.status) {
            case "Open":
                icon = "\u2731";
                break;
            case "In Progress":
                icon = "\u219D";
                break;
            case "Complete":
                icon = "\u2714";
                return `[${icon}] ${this.title}`;
                break;
        }

        return `[${icon}] ${this.title} (deadline: ${this.deadline})`;
    }
}

let date1 = new Date();
let date2 = new Date();
date2.setDate(date2.getDate() + 7);
date1.setDate(date1.getDate() + 7);

let task1 = new Task('JS Homework', date1);
let task2 = new Task('JS Homework 2', date2);
task1.status = "Complete";

let tasks = [task1, task2].sort(Task.comparator);

for (let task of tasks) {
    console.log(task.toString());
}