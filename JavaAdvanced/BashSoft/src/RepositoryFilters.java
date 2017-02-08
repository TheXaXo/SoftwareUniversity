import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

public class RepositoryFilters {

    public static void printFilteredStudents(
            HashMap<String, ArrayList<Integer>> courseData,
            String filterType,
            Integer numberOfStudents) {

        Predicate<Double> filter = createFilter(filterType);

        if (filter == null) {
            OutputWriter.writeMessageOnNewLine(ExceptionMessages.INVALID_FILTER);
            return;
        }

        int studentsCount = 0;
        for (String student : courseData.keySet()) {

            if (numberOfStudents == studentsCount) {
                break;
            }

            ArrayList<Integer> studentMarks = courseData.get(student);
            Double averageMark = getStudentAverageGrade(studentMarks);

            if (filter.test(averageMark)) {
                OutputWriter.printStudent(student, studentMarks);
                studentsCount++;
            }
        }
    }

    private static Predicate<Double> createFilter(String filterType) {
        switch (filterType) {
            case "excellent":
                return mark -> mark >= 5;

            case "average":
                return mark -> mark >= 3.5 && mark < 5;

            case "poor":
                return mark -> mark < 3.5;

            default:
                return null;
        }
    }

    private static Double getStudentAverageGrade(ArrayList<Integer> grades) {
        double totalScore = 0;

        for (double grade : grades) {
            totalScore += grade;
        }

        double percentage = totalScore / (grades.size() * 100);
        return (percentage * 4) + 2;
    }
}