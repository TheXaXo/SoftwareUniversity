import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\TheXaXo\\Desktop\\Files-and-Streams");

        File[] filesInDirectory = directory.listFiles();

        for (File file : filesInDirectory) {
            if (!file.isDirectory()) {
                System.out.printf("%s: %d%n", file.getName(), file.length());
            }
        }
    }
}