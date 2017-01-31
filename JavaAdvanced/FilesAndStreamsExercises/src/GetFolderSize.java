import java.io.File;
import java.util.ArrayDeque;
import java.util.Scanner;

public class GetFolderSize {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String path = console.nextLine();

        File file = new File(path);

        ArrayDeque<File> filesToCheck = new ArrayDeque<>();
        filesToCheck.add(file);

        long size = 0;

        while (!filesToCheck.isEmpty()) {
            File fileToCheck = filesToCheck.remove();

            if (fileToCheck.isDirectory()) {
                File[] childs = fileToCheck.listFiles();

                for (File child : childs) {
                    filesToCheck.add(child);
                }
            } else {
                size += fileToCheck.length();
            }
        }

        System.out.printf("Folder size: %d", size);
    }
}