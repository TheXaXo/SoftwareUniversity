import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\TheXaXo\\Desktop\\Files-and-Streams");

        ArrayDeque<File> folders = new ArrayDeque<>();
        folders.add(file);

        int counter = 1;

        while (!folders.isEmpty()) {
            File[] filesInFolder = folders.peek().listFiles();

            for (File fileToCheck : filesInFolder) {
                if (fileToCheck.isDirectory()) {
                    folders.add(fileToCheck);

                    counter++;
                }
            }

            System.out.println(folders.remove().getName());
        }

        System.out.println(counter + " folders");
    }
}