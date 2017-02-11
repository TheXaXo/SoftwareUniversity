import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static ArrayList<Student> getStudents() {
        Path studentsDataPath = Paths.get("C:\\Users\\TheXaXo\\Desktop\\StudentData.txt");
        List<String> data = new ArrayList<>();

        ArrayList<Student> students = new ArrayList<>();

        try {
            data = Files.readAllLines(studentsDataPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < data.size(); i++) {
            String[] tokens = data.get(i).split("\\s+");

            Student student = new Student();
            student.facultyNumber = tokens[0];
            student.firstName = tokens[1];
            student.lastName = tokens[2];
            student.email = tokens[3];
            student.age = Integer.parseInt(tokens[4]);
            student.group = Integer.parseInt(tokens[5]);
            student.phone = tokens[10];

            student.grades = new ArrayList<>();

            for (int j = 6; j < 10; j++) {
                student.grades.add(Integer.parseInt(tokens[j]));
            }

            students.add(student);
        }

        return students;
    }
}