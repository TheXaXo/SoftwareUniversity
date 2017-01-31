import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String input = "C:\\Users\\TheXaXo\\Desktop\\input.txt";
        String output = "C:\\Users\\TheXaXo\\Desktop\\output.txt";

        try (FileInputStream fis = new FileInputStream(input);
             FileOutputStream fos = new FileOutputStream(output)) {
            int oneByte = fis.read();

            while (oneByte >= 0) {
                if (oneByte == ' ' || oneByte == '\n') {
                    fos.write(oneByte);
                } else {
                    String oneByteStr = String.valueOf(oneByte);

                    for (char c : oneByteStr.toCharArray()) {
                        fos.write(c);
                    }
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
