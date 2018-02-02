package javache.io;

import javache.WebConstants;
import javache.models.User;

import java.io.*;

public final class Writer {
    private Writer() {
    }

    public static void writeBytes(byte[] byteData, OutputStream outputStream) throws IOException {
        DataOutputStream buffer = new DataOutputStream(outputStream);

        buffer.write(byteData);
    }

    public static void writeUser(User user) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(WebConstants.DB_FOLDER + "\\users.txt", true));

        writer.write(user.getId() + "|" + user.getEmail() + "|" + user.getPassword() + System.lineSeparator());
        writer.flush();
    }
}