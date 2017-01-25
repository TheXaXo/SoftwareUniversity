import java.util.ArrayList;

public class OutputWriter {

    public static void writeMessage(String message) {
        System.out.print(message);
    }

    public static void writeMessageOnNewLine(String message) {
        System.out.println(message);
    }

    public static void writeEmptyLine() {
        System.out.println();
    }

    public static void displayException(String message) {
        System.out.print(message);
    }

    public static void printStudent(String name, ArrayList<Integer> grades) {
        OutputWriter.writeMessageOnNewLine(String.format("%s - %s", name, grades.toString()));
    }
}
