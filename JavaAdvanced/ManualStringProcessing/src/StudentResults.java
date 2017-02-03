import java.util.*;

public class StudentResults {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String row = console.nextLine();

            String[] split = row.split("-");
            String name = split[0].trim();

            split = split[1].split(", ");
            String javaAdvanced = split[0].trim();
            String oop = split[1].trim();
            String advOop = split[2].trim();

            Student student = new Student();
            student.name = name;
            student.javaAdvanced = Double.parseDouble(javaAdvanced);
            student.oop = Double.parseDouble(oop);
            student.advOop = Double.parseDouble(advOop);

            student.getAverage();

            students.add(student);
        }

        if (!students.isEmpty()) {
            System.out.printf("%-10s|%7s|%7s|%7s|%7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        }

        students.sort(Comparator.comparing(a -> a.name));

        for (Student student : students) {
            System.out.print(String.format("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|%n",
                    student.name, student.javaAdvanced, student.oop, student.advOop, student.average).replace(".", ","));
        }
    }
}

class Student {
    String name;
    double javaAdvanced = 0;
    double oop = 0;
    double advOop = 0;
    double average = 0;

    public double getAverage() {
        return average = (javaAdvanced + oop + advOop) / 3;
    }
}