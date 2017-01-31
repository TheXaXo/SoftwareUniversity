import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\TheXaXo\\Desktop\\input.txt";
        String outputPath = "C:\\Users\\TheXaXo\\Desktop\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            String line = reader.readLine();

            while (line != null) {
                writer.println(line.toUpperCase());

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
