package javache.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class Reader {
    private Reader() {
    }

    public static String readAllLines(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder resultSb = new StringBuilder();

        while (bufferedReader.ready()) {
            resultSb.append((char) bufferedReader.read());
        }

        return resultSb.toString();
    }
}