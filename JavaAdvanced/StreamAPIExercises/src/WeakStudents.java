import java.util.ArrayList;
import java.util.Comparator;

public class WeakStudents {
    public static void main(String[] args) {
        ArrayList<Student> students = Main.getStudents();

        students.stream()
                .filter(student -> {
                    if (student.grades.stream().filter(grade -> grade <= 3).count() >= 2) {
                        return true;
                    }

                    return false;
                })
                .sorted(Comparator.<Student>comparingDouble(student -> student.grades.stream().mapToInt(a -> a).average().orElse(0)))
                .forEach(student -> {
                    System.out.printf("%s %s ", student.firstName, student.lastName);

                    student.grades.stream()
                            .sorted()
                            .forEach(grade -> System.out.print(grade + " "));

                    System.out.println();
                });
    }
}