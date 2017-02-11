import java.util.ArrayList;

public class StudentsByAge {
    public static void main(String[] args) {
        ArrayList<Student> students = Main.getStudents();

        students.stream()
                .filter(student -> student.age >= 18 && student.age <= 24)
                .forEach(student -> System.out.println(student.firstName + " " + student.lastName + " " + student.age));
    }
}