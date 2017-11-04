import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, SQLException, InstantiationException {
        Connector.createConnection("root", "", "orm_db");
        EntityManager<User> entityManager = new EntityManager<>(Connector.getConnection());
    }
}