import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String fileOne = "C:\\Users\\TheXaXo\\Desktop\\file1.txt";
        String fileTwo = "C:\\Users\\TheXaXo\\Desktop\\file2.txt";
        String outputFile = "C:\\Users\\TheXaXo\\Desktop\\output.txt";

        try (BufferedReader fileOneReader = new BufferedReader(new FileReader(fileOne));
             BufferedReader fileTwoReader = new BufferedReader(new FileReader(fileTwo));
             PrintWriter writer = new PrintWriter(outputFile)) {

            String line = fileOneReader.readLine();

            while (line != null) {
                writer.println(line);

                line = fileOneReader.readLine();
            }

            line = fileTwoReader.readLine();

            while (line != null) {
                writer.println(line);

                line = fileTwoReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}