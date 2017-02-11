import java.util.ArrayList;
import java.util.Comparator;

public class StudentsByGroup {
    public static void main(String[] args) {
        ArrayList<Student> students = Main.getStudents();

        students.stream()
                .filter(student -> student.group == 2)
                .sorted(Comparator.comparing(student -> student.firstName))
                .forEach(student -> System.out.println(student.firstName + " " + student.lastName));
    }
}