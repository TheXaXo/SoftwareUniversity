import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class StudentsByEnrollmentYear {
    public static void main(String[] args) {
        ArrayList<Student> students = Main.getStudents();

        HashMap<Integer, ArrayList<Student>> yearStudents = new HashMap<>();

        for (Student student : students) {
            String year = "20" + student.facultyNumber.substring(student.facultyNumber.length() - 2);

            if (!yearStudents.containsKey(Integer.parseInt(year))) {
                yearStudents.put(Integer.parseInt(year), new ArrayList<>());
                yearStudents.get(Integer.parseInt(year)).add(student);
            } else {
                yearStudents.get(Integer.parseInt(year)).add(student);
            }
        }

        yearStudents.entrySet().stream()
                .sorted(Comparator.comparingInt(a -> a.getKey()))
                .forEach(pair -> {
                    System.out.printf("%d:%n", pair.getKey());

                    pair.getValue().stream()
                            .sorted(Comparator.comparing(a -> a.firstName + a.lastName))
                            .forEach(student -> System.out.printf("-- %s %s%n", student.firstName, student.lastName));
                });
    }
}