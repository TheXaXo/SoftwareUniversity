import java.util.ArrayList;

public class FilterStudentsByPhone {
    public static void main(String[] args) {
        ArrayList<Student> students = Main.getStudents();

        students.stream()
                .filter(student -> {
                    if (student.phone.startsWith("02") || student.phone.startsWith("+3592")) {
                        return true;
                    }

                    return false;
                })
                .forEach(student -> System.out.printf("%s %s %s%n", student.firstName, student.lastName, student.phone));
    }
}