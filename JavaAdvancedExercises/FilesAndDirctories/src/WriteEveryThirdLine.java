import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String input = "C:\\Users\\TheXaXo\\Desktop\\input.txt";
        String output = "C:\\Users\\TheXaXo\\Desktop\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             PrintWriter print = new PrintWriter(output)) {

            String line = reader.readLine();
            int counter = 1;

            while (line != null) {
                if (counter % 3 == 0) {
                    print.println(line);
                }

                counter++;
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}