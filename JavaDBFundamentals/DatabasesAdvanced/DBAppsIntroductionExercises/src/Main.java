import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MinionsDB", properties);
        addMinion(connection, "Bob", 14, "Berlin", "Gru");
    }

    private static void getVillainsNames(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT name, COUNT(mv.minion_id) AS minions_count\n" +
                "FROM villains AS v\n" +
                "JOIN minions_villains AS mv ON v.id = mv.villain_id\n" +
                "GROUP BY mv.villain_id\n" +
                "HAVING minions_count > 2\n" +
                "ORDER BY minions_count DESC;");
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            System.out.printf("%s %d%n", result.getString("name"), result.getInt("minions_count"));
        }
    }

    private static void getMinionNames(Connection connection, int villainId) throws SQLException {
        PreparedStatement villainStatement = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
        villainStatement.setInt(1, villainId);
        ResultSet villainResult = villainStatement.executeQuery();

        if (villainResult.next()) {
            System.out.printf("Villain: %s%n", villainResult.getString("name"));
        } else {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            return;
        }

        PreparedStatement minionsStatement = connection.prepareStatement("SELECT name, age\n" +
                "FROM minions AS m\n" +
                "JOIN minions_villains AS mv ON m.id = mv.minion_id\n" +
                "WHERE mv.villain_id = ?;");
        minionsStatement.setInt(1, villainId);
        ResultSet minionsResult = minionsStatement.executeQuery();

        if (!minionsResult.isBeforeFirst()) {
            System.out.println("<no minions>");
        } else {
            int index = 1;

            while (minionsResult.next()) {
                System.out.printf("%d. %s %d%n", index++, minionsResult.getString("name"), minionsResult.getInt("age"));
            }
        }
    }

    private static void addMinion(Connection connection, String minionName, int minionAge, String minionCity, String villainName) throws SQLException {
        if (getCityIdByName(connection, minionCity) == -1) {
            PreparedStatement cityAddStatement = connection.prepareStatement("INSERT INTO towns(name, country)" +
                    "VALUES (?, NULL)");
            cityAddStatement.setString(1, minionCity);
            cityAddStatement.executeUpdate();
            System.out.printf("Town %s was added to the database.%n", minionCity);
        }

        PreparedStatement minionStatement = connection.prepareStatement("INSERT INTO minions(name, age, town_id)" +
                "VALUES (?, ?, ?)");
        minionStatement.setString(1, minionName);
        minionStatement.setInt(2, minionAge);
        minionStatement.setInt(3, getCityIdByName(connection, minionCity));
        minionStatement.executeUpdate();

        if (getVillainIdByName(connection, villainName) == -1) {
            PreparedStatement villainAddStatement = connection.prepareStatement("INSERT INTO villains(name, evilness_factor)" +
                    "VALUES (?, 'evil')");
            villainAddStatement.setString(1, villainName);
            villainAddStatement.executeUpdate();

            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        PreparedStatement minionVillainStatement = connection.prepareStatement("INSERT INTO minions_villains(minion_id, villain_id)" +
                "VALUES (?, ?)");
        minionVillainStatement.setInt(1, getMinionIdByName(connection, minionName));
        minionVillainStatement.setInt(2, getVillainIdByName(connection, villainName));
        minionVillainStatement.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
    }

    private static int getCityIdByName(Connection connection, String name) throws SQLException {
        PreparedStatement cityStatement = connection.prepareStatement("SELECT id FROM towns WHERE name = ?");
        cityStatement.setString(1, name);
        ResultSet cityResult = cityStatement.executeQuery();

        if (!cityResult.next()) {
            return -1;
        } else {
            return cityResult.getInt("id");
        }
    }

    private static int getVillainIdByName(Connection connection, String name) throws SQLException {
        PreparedStatement villainStatement = connection.prepareStatement("SELECT id FROM villains WHERE name = ?");
        villainStatement.setString(1, name);

        ResultSet villainResult = villainStatement.executeQuery();

        if (!villainResult.next()) {
            return -1;
        } else {
            return villainResult.getInt("id");
        }
    }

    private static int getMinionIdByName(Connection connection, String name) throws SQLException {
        PreparedStatement minionStatement = connection.prepareStatement("SELECT id FROM minions WHERE name = ?");
        minionStatement.setString(1, name);

        ResultSet minionResult = minionStatement.executeQuery();

        if (!minionResult.next()) {
            return -1;
        } else {
            return minionResult.getInt("id");
        }
    }
}