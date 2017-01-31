import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        Path input = Paths.get("C:\\Users\\TheXaXo\\Desktop\\input.txt");
        Path output = Paths.get("C:\\Users\\TheXaXo\\Desktop\\output.txt");

        try {
            List<String> lines = Files.readAllLines(input);

            Collections.sort(lines);

            Files.write(output, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
