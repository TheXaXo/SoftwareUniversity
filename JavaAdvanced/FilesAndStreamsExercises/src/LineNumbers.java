import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\TheXaXo\\Desktop\\input.txt";
        String outputPath = "C:\\Users\\TheXaXo\\Desktop\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            String line = reader.readLine();

            int lineNumber = 1;

            while (line != null) {
                writer.printf("%d. %s%n", lineNumber, line);

                lineNumber++;
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}