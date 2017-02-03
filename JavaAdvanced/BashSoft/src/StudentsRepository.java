import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StudentsRepository {
    public static boolean isDataInitialized = false;
    public static HashMap<String, HashMap<String, ArrayList<Integer>>> studentsByCourse;

    public static void initializeData(String fileName) throws IOException {
        if (isDataInitialized) {
            OutputWriter.writeMessageOnNewLine(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        studentsByCourse = new HashMap<>();
        readData(fileName);
    }

    private static void readData(String fileName) throws IOException {
        String path = SessionData.currentPath + "\\" + fileName;
        List<String> lines = Files.readAllLines(Paths.get(path));

        for (String line : lines) {
            String[] tokens = line.split("\\s+");

            String course = tokens[0];
            String student = tokens[1];
            Integer mark = Integer.parseInt(tokens[2]);

            if (!studentsByCourse.containsKey(course)) {
                studentsByCourse.put(course, new HashMap<>());
            }

            if (!studentsByCourse.get(course).containsKey(student)) {
                studentsByCourse.get(course).put(student, new ArrayList<>());
            }

            studentsByCourse.get(course).get(student).add(mark);
        }

        isDataInitialized = true;
        OutputWriter.writeMessageOnNewLine("Data read.");
    }

    private static boolean isQueryForCoursePossible(String courseName) {
        if (!isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }

        if (!studentsByCourse.containsKey(courseName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTENT_COURSE);
            return false;
        }

        return true;
    }

    private static boolean isQueryForStudentPossible(String courseName, String studentName) {
        if (!isQueryForCoursePossible(courseName)) {
            return false;
        }

        if (!studentsByCourse.get(courseName).containsKey(studentName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_STUDENT);

            return false;
        }

        return true;
    }

    public static void getStudentMarksInCourse(String studentName, String courseName) {
        if (!isQueryForStudentPossible(courseName, studentName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_STUDENT);
            return;
        }

        ArrayList<Integer> grades = studentsByCourse.get(courseName).get(studentName);
        OutputWriter.printStudent(studentName, grades);
    }

    public static void getStudentsByCourse(String courseName) {
        if (!isQueryForCoursePossible(courseName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTENT_COURSE);
            return;
        }

        for (Map.Entry<String, ArrayList<Integer>> students : studentsByCourse.get(courseName).entrySet()) {
            OutputWriter.printStudent(students.getKey(), students.getValue());
        }
    }
}