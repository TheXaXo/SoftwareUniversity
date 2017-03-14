import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        TreeMap<String, Double> studentGrade = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String studentName = console.nextLine();
            String[] grades = console.nextLine().split(" ");

            double gradeSum = 0;

            for (String grade : grades) {
                gradeSum += Double.parseDouble(grade);
            }

            studentGrade.put(studentName, gradeSum / grades.length);
        }

        for (String studentName : studentGrade.keySet()) {
            System.out.printf("%s is graduated with %s%n", studentName, studentGrade.get(studentName));
        }
    }
}