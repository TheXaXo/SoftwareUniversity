import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern p = Pattern.compile("([A-Z][A-Za-z+#]*_[A-Z][a-z]{2}_\\d{4})\\s+([A-Z][a-z]{1,3}\\d{2}_\\d{2,4})\\s+(\\d+)");

        String path = SessionData.currentPath + "\\" + fileName;
        List<String> lines = Files.readAllLines(Paths.get(path));

        for (String line : lines) {
            Matcher m = p.matcher(line);

            if (!line.isEmpty() && m.find()) {
                String course = m.group(1);
                String student = m.group(2);
                int mark = Integer.parseInt(m.group(3));

                if (mark >= 0 && mark <= 100) {
                    if (!studentsByCourse.containsKey(course)) {
                        studentsByCourse.put(course, new HashMap<>());
                    }

                    if (!studentsByCourse.get(course).containsKey(student)) {
                        studentsByCourse.get(course).put(student, new ArrayList<>());
                    }

                    studentsByCourse.get(course).get(student).add(mark);
                }
            }
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