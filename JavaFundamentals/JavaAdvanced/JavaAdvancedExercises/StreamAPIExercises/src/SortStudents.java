import java.util.ArrayList;
import java.util.Comparator;

public class SortStudents {
    public static void main(String[] args) {
        ArrayList<Student> students = Main.getStudents();

        Comparator<Student> comparator1 = Comparator.comparing(student -> student.lastName);
        Comparator<Student> comparator2 = comparator1.thenComparing((s1, s2) -> s2.firstName.compareTo(s1.firstName));

        students.stream()
                .sorted(comparator2)
                .forEach(student -> System.out.println(student.firstName + " " + student.lastName));

    }
}