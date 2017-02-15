import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\TheXaXo\\Desktop\\course.ser"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\TheXaXo\\Desktop\\course.ser"))) {

            Course sampleCourse = new Course();
            sampleCourse.name = "Sample course";
            sampleCourse.numberOfStudents = 69;

            oos.writeObject(sampleCourse);

            Course courseFromSave = (Course) ois.readObject();

            System.out.println(courseFromSave.name);
            System.out.println(courseFromSave.numberOfStudents);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Course implements Serializable {
    String name;
    int numberOfStudents = 0;
}