package javache.repositories;

import javache.WebConstants;
import javache.models.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static User findOneByEmail(String email) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(WebConstants.DB_FOLDER + "\\users.txt"));
        String line = reader.readLine();

        while (line != null) {
            String[] data = line.split("\\|");

            if (data[1].equals(email)) {
                return new User(data[0], data[1], data[2]);
            }

            line = reader.readLine();
        }

        return null;
    }

    public static List<User> findAll() throws IOException {
        List<User> users = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(WebConstants.DB_FOLDER + "\\users.txt"));
        String line = reader.readLine();

        while (line != null) {
            String[] data = line.split("\\|");

            User user = new User(data[0], data[1], data[2]);
            users.add(user);

            line = reader.readLine();
        }

        return users;
    }
}