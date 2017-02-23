package bg.softuni.models;

import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class Student {
    private String userName;
    private LinkedHashMap<String, Course> enrolledCourses;
    private LinkedHashMap<String, Double> marksByCourseName;

    public Student(String userName) {
        this.userName = userName;
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    public String getUserName() {
        return this.userName;
    }

    public LinkedHashMap<String, Double> getMarksByCourseName() {
        return this.marksByCourseName;
    }

    public void enrollInCourse(Course course) {
        if (this.enrolledCourses.containsKey(course.getName())) {
            OutputWriter.displayException(String.format(
                    ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE,
                    this.userName,
                    course.getName()));

            return;
        }

        this.enrolledCourses.put(course.getName(), course);
    }

    public void setMarkOnCourse(String courseName, int[] scores) {
        if (!this.enrolledCourses.containsKey(courseName)) {
            OutputWriter.displayException(ExceptionMessages.STUDENT_NOT_ENROLLED_IN_COURSE);
            return;
        }

        if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM) {
            OutputWriter.displayException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
            return;
        }

        double mark = calculateMark(scores);
    }

    private double calculateMark(int[] scores) {
        double percentageOfSolvedExam = Arrays.stream(scores).sum() /
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM * Course.MAX_SCORE_ON_EXAM_TASK);
        return percentageOfSolvedExam * 4 + 2;
    }
}