import java.util.ArrayList;

public class FilterStudentsByEmailDomain {
    public static void main(String[] args) {
        ArrayList<Student> students = Main.getStudents();

        students.stream()
                .filter(student -> {
                    String emailDomain = student.email.split("@")[1];

                    return emailDomain.equals("gmail.com");
                })
                .forEach(student -> System.out.println(student.firstName + " " + student.lastName + " " + student.email));
    }
}