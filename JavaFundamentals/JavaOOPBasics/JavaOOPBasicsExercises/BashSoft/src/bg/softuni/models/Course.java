package bg.softuni.models;

import bg.softuni.exceptions.DuplicateEntryInStructureException;
import bg.softuni.exceptions.InvalidNameVariableException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Course {
    private String name;
    private LinkedHashMap<String, Student> studentsByName;

    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK = 100;

    public Course(String name) {
        this.setName(name);
        this.studentsByName = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new InvalidNameVariableException();
        }

        this.name = name;
    }

    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(this.studentsByName);
    }

    public void enrollStudent(Student student) {
        if (this.studentsByName.containsKey(student.getUserName())) {
            throw new DuplicateEntryInStructureException(
                    student.getUserName(),
                    this.name);
        }

        this.studentsByName.put(student.getUserName(), student);
    }
}