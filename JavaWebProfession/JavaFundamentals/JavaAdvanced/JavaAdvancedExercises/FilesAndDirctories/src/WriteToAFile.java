import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

public class WriteToAFile {
    public static void main(String[] args) {
        String input = "C:\\Users\\TheXaXo\\Desktop\\input.txt";
        String output = "C:\\Users\\TheXaXo\\Desktop\\output.txt";

        HashSet<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, '.', ',', '!', '?');

        try (FileInputStream fis = new FileInputStream(input);
             FileOutputStream fos = new FileOutputStream(output)) {
            int oneByte = fis.read();

            while (oneByte >= 0) {
                if (!punctuation.contains((char) oneByte)) {
                    fos.write(oneByte);
                }

                oneByte = fis.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}