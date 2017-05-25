import java.util.ArrayList;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) {
        ArrayList<Student> students = Main.getStudents();

        students.stream()
                .filter(student -> student.firstName.compareTo(student.lastName) < 0)
                .forEach(student -> System.out.println(student.firstName + " " + student.lastName));
    }
}