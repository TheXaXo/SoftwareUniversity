package orm;

import java.sql.SQLException;

public interface DbContext<E> {
    boolean persist(E entity) throws IllegalAccessException, SQLException;

    Iterable<E> find(Class<E> table) throws IllegalAccessException, SQLException, InstantiationException;

    Iterable<E> find(Class<E> table, String where) throws IllegalAccessException, SQLException, InstantiationException;

    E findFirst(Class<E> table) throws IllegalAccessException, SQLException, InstantiationException;

    E findFirst(Class<E> table, String where) throws SQLException, IllegalAccessException, InstantiationException;
}
