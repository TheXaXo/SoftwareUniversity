import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class IOManager {

    public static void main(String[] args) {
        StudentsRepository.initializeData();
        StudentsRepository.getStudentsByCourse("Unity");
    }

    public static void traverseDirectory(String path) {
        LinkedList<File> subFolders = new LinkedList<>();
        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0) {
            File currentFolder = subFolders.removeFirst();

            if (currentFolder.listFiles() != null) {
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()) {
                        try {
                            subFolders.add(file);
                        } catch (IllegalAccessError a) {
                            OutputWriter.writeMessageOnNewLine("Access denied");
                        }
                    }
                }
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());
        }
    }
}