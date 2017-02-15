import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String input = "C:\\Users\\TheXaXo\\Desktop\\input.txt";
        String output = "C:\\Users\\TheXaXo\\Desktop\\output.txt";

        try (Scanner scr = new Scanner(new FileInputStream(input));
             PrintWriter print = new PrintWriter(output)) {

            while (scr.hasNext()) {
                if (scr.hasNextInt()) {
                    print.println(scr.nextInt());
                }

                scr.next();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}