import java.util.ArrayList;
import java.util.Comparator;

public class ExcellentStudents {
    public static void main(String[] args) {
        ArrayList<Student> students = Main.getStudents();

        students.stream()
                .filter(student -> {
                    if (student.grades.contains(6)) {
                        return true;
                    }

                    return false;
                })
                .forEach(student -> {
                    System.out.printf("%s %s ", student.firstName, student.lastName);

                    student.grades.stream()
                            .sorted(Comparator.<Integer>comparingInt(a -> a).reversed())
                            .forEach(grade -> System.out.print(grade + " "));

                    System.out.println();
                });
    }
}