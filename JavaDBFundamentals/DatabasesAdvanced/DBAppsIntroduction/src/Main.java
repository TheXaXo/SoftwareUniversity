import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);
        PreparedStatement statement = connection.prepareStatement(
                "SELECT CONCAT(first_name, ' ', last_name) AS full_name, COUNT(game_id) AS games_count\n" +
                        "FROM users AS u\n" +
                        "JOIN users_games AS ug ON u.id = ug.user_id\n" +
                        "WHERE user_name = ?;");

        System.out.print("Enter username: ");
        String username = reader.readLine();
        statement.setString(1, username);

        ResultSet result = statement.executeQuery();
        result.next();

        if (result.getString("full_name") == null) {
            System.out.println("No such user exists");
        } else {
            System.out.printf("%s has played %d games", result.getString("full_name"), result.getInt("games_count"));
        }
    }
}