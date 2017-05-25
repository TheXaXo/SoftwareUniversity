import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\TheXaXo\\Desktop\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line = reader.readLine();

            long sum = 0;

            while (line != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }

                line = reader.readLine();
            }

            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}