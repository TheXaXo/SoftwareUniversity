import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\TheXaXo\\Desktop\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line = reader.readLine();

            while (line != null) {
                int sum = 0;

                for (char c : line.toCharArray()) {
                    sum += c;
                }

                System.out.println(sum);

                line = reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}