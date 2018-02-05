package org.softuni.main.javache.io;

import org.softuni.main.database.models.User;
import org.softuni.main.javache.WebConstants;

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

        writer.write(user.getId() + "|" + user.getUsername() + "|" + user.getPassword() + System.lineSeparator());
        writer.flush();
    }
}