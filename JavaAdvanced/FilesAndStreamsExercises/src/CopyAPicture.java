import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CopyAPicture {
    public static void main(String[] args) {

        try (FileInputStream input = new FileInputStream("C:\\Users\\TheXaXo\\Desktop\\input.jpg");
             FileOutputStream output = new FileOutputStream("C:\\Users\\TheXaXo\\Desktop\\picture-copy.jpg")) {
            int oneByte = input.read();

            ArrayList<Integer> bytes = new ArrayList<>();

            while (oneByte != -1) {
                bytes.add(oneByte);

                oneByte = input.read();
            }

            for (Integer oneByteToWrite : bytes) {
                output.write(oneByteToWrite);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}