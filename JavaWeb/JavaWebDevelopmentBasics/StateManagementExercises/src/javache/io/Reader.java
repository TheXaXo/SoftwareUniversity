package javache.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Reader {
    private Reader() {
    }

    public static String readAllLines(InputStream inputStream) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder result = new StringBuilder();

        while (buffer.ready()) {
            result.append((char) buffer.read());
        }

        return result.toString();
    }

    public static byte[] readFile(String filePath) {
        try {
            return Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}