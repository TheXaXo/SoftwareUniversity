import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class IOManager {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);

        CommandInterpreter.interpretCommand(console.nextLine());
    }

    public static void traverseDirectory(int depth) {
        LinkedList<File> subFolders = new LinkedList<>();

        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\\\").length;

        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0) {
            File currentFolder = subFolders.removeFirst();
            int currentIndentation = currentFolder.toString().split("\\\\").length - initialIndentation;

            if (depth - currentIndentation < 0) {
                break;
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());

            if (currentFolder.listFiles() != null) {
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()) {
                        try {
                            subFolders.add(file);
                        } catch (IllegalAccessError a) {
                            OutputWriter.writeMessageOnNewLine("Access denied");
                        }
                    } else {
                        int indexOfLastSlash = file.toString().lastIndexOf("\\");

                        for (int i = 0; i < indexOfLastSlash; i++) {
                            OutputWriter.writeMessage("-");
                        }

                        OutputWriter.writeMessageOnNewLine(file.getName());
                    }
                }
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());
        }
    }

    public static void createDirectoryInCurrentFolder(String name) {
        String path = getCurrentDirectoryPath() + "\\" + name;

        File file = new File(path);
        file.mkdir();
    }

    public static String getCurrentDirectoryPath() {
        return SessionData.currentPath;
    }

    public static void changeCurrentDirRelativePath(String relativePath) {
        if (relativePath.equals("..")) {
            String currentPath = SessionData.currentPath;
            int indexOfLastSlash = currentPath.lastIndexOf("\\");

            String newPath = currentPath.substring(0, indexOfLastSlash);
            SessionData.currentPath = newPath;
        } else {
            String currentPath = SessionData.currentPath;
            currentPath += "\\" + relativePath;
            changeCurrentDirAbsolute(currentPath);
        }
    }

    public static void changeCurrentDirAbsolute(String absolutePath) {
        File file = new File(absolutePath);

        if (!file.exists()) {
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);

            return;
        }

        SessionData.currentPath = absolutePath;
    }
}