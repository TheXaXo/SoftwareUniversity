package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class EntityManager<E> implements DbContext<E> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);
        Object value = primary.get(entity);

        if (value == null || (int) value <= 0) {
            return this.doInsert(entity);
        }

        return this.doUpdate(entity);
    }

    public Iterable<E> find(Class<E> table) throws IllegalAccessException, SQLException, InstantiationException {
        String query = "SELECT * FROM " + table.getDeclaredAnnotation(Entity.class).name() + ";";

        return getAllEntities(query, table);
    }

    public Iterable<E> find(Class<E> table, String where) throws IllegalAccessException, SQLException, InstantiationException {
        String query = "SELECT * FROM " + table.getDeclaredAnnotation(Entity.class).name() + " WHERE " + where + ";";

        return getAllEntities(query, table);
    }

    public E findFirst(Class<E> table) throws IllegalAccessException, SQLException, InstantiationException {
        String query = "SELECT * FROM " + table.getDeclaredAnnotation(Entity.class).name() + " LIMIT 1;";

        return getFirstEntity(query, table);
    }

    public E findFirst(Class<E> table, String where) throws SQLException, IllegalAccessException, InstantiationException {
        String query = "SELECT * FROM " + table.getDeclaredAnnotation(Entity.class).name() + " WHERE " + where + " LIMIT 1;";

        return getFirstEntity(query, table);
    }

    private E getFirstEntity(String query, Class<E> table) throws SQLException, IllegalAccessException, InstantiationException {
        ResultSet result = this.connection.prepareStatement(query).executeQuery();
        result.next();

        E entity = table.newInstance();
        this.fillEntity(table, result, entity);

        return entity;
    }

    private Iterable<E> getAllEntities(String query, Class<E> table) throws SQLException, IllegalAccessException, InstantiationException {
        List<E> allEntities = new ArrayList<>();
        ResultSet result = this.connection.prepareStatement(query).executeQuery();

        while (result.next()) {
            E entity = table.newInstance();
            this.fillEntity(table, result, entity);
            allEntities.add(entity);
        }

        return allEntities;
    }

    private void fillEntity(Class<E> table, ResultSet result, E entity) throws SQLException, IllegalAccessException {
        for (Field field : table.getDeclaredFields()) {
            field.setAccessible(true);
            this.fillField(field, entity, result, field.getDeclaredAnnotation(Column.class).name());
        }
    }

    private void fillField(Field field, Object instance, ResultSet result, String fieldName) throws SQLException, IllegalAccessException {
        field.setAccessible(true);

        if (field.getType() == int.class || field.getType() == Integer.class) {
            field.set(instance, result.getInt(fieldName));
        } else if (field.getType() == long.class || field.getType() == Long.class) {
            field.set(instance, result.getLong(fieldName));
        } else if (field.getType() == String.class) {
            field.set(instance, result.getString(fieldName));
        } else if (field.getType() == boolean.class) {
            field.set(instance, result.getBoolean(fieldName));
        } else if (field.getType() == double.class) {
            field.set(instance, result.getDouble(fieldName));
        } else if (field.getType() == Date.class) {
            field.set(instance, result.getDate(fieldName));
        }
    }

    private Field getId(Class entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have primary key."));
    }

    private boolean doInsert(E entity) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity);
        String query = "INSERT INTO " + tableName + "(";
        String fields = "";
        String values = "";

        Field[] fieldsWithoutPrimaryKey = Arrays.stream(entity.getClass().getDeclaredFields()).
                filter(field -> field.getDeclaredAnnotations().length == 1)
                .toArray(Field[]::new);

        for (Field field : fieldsWithoutPrimaryKey) {
            field.setAccessible(true);
            fields += field.getDeclaredAnnotation(Column.class).name() + ", ";

            Object value = field.get(entity);
            values += formatValue(value) + ", ";
        }

        fields = fields.substring(0, fields.length() - 2);
        values = values.substring(0, values.length() - 2);

        query = query + fields + ") VALUES (" + values + ");";
        return this.connection.prepareStatement(query).execute();
    }

    private boolean doUpdate(E entity) throws IllegalAccessException, SQLException {
        String tableName = this.getTableName(entity);
        String query = "UPDATE " + tableName + " SET ";
        String newValues = "";

        Field idField = this.getId(entity.getClass());
        idField.setAccessible(true);
        Object id = idField.get(entity);

        Field[] allFieldsWithoutPrimaryKey = Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.getDeclaredAnnotations().length == 1)
                .toArray(Field[]::new);

        for (Field field : allFieldsWithoutPrimaryKey) {
            field.setAccessible(true);
            Object value = field.get(entity);
            newValues += field.getDeclaredAnnotation(Column.class).name() + " = " + formatValue(value) + ", ";
        }

        newValues = newValues.substring(0, newValues.length() - 2);
        query = query + newValues + " WHERE " + idField.getDeclaredAnnotation(Column.class).name() + " = " + formatValue(id) + ";";
        return this.connection.prepareStatement(query).execute();
    }

    private String getTableName(E entity) {
        Entity tableNameAnnotation = entity.getClass().getDeclaredAnnotation(Entity.class);
        return tableNameAnnotation.name();
    }

    private String formatDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    private Object formatValue(Object value) {
        if (value instanceof Date) {
            return "\"" + formatDate((Date) value) + "\"";
        } else if (value instanceof String) {
            return "\"" + value + "\"";
        } else {
            return value;
        }
    }

    private void doCreate(Class entity) throws SQLException {
        Entity tableNameAnnotation = (Entity) entity.getDeclaredAnnotation(Entity.class);
        String tableName = tableNameAnnotation.name();
        String query = "CREATE TABLE " + tableName + "( ";
        String columns = "";
        Field[] allFields = entity.getDeclaredFields();

        for (Field field : allFields) {
            field.setAccessible(true);
            String type = getMySQLDataTypeFromField(field);
            String name = field.getDeclaredAnnotation(Column.class).name();

            if (field.isAnnotationPresent(Id.class)) {
                columns += name + " INTEGER PRIMARY KEY AUTO_INCREMENT, ";
                continue;
            }

            columns += name + " " + type + ", ";
        }

        columns = columns.substring(0, columns.length() - 2);
        query = query + columns + ");";
        this.connection.prepareStatement(query).execute();
    }

    private void doAlter(Class entity) throws SQLException {
        Entity tableNameAnnotation = (Entity) entity.getDeclaredAnnotation(Entity.class);
        String tableName = tableNameAnnotation.name();
        String query = "ALTER TABLE " + tableName + " ";

        for (Field field : entity.getDeclaredFields()) {
            field.setAccessible(true);

            if (checkIfFieldExistsInDatabase(field, tableName)) {
                continue;
            }

            query += "ADD COLUMN " + field.getDeclaredAnnotation(Column.class).name() + " " + getMySQLDataTypeFromField(field) + ", ";
        }

        query = query.substring(0, query.length() - 2);
        query += ";";
        connection.prepareStatement(query).execute();
    }

    private void doDelete(Class entity, String where) throws SQLException {
        Entity tableNameAnnotation = (Entity) entity.getDeclaredAnnotation(Entity.class);
        String tableName = tableNameAnnotation.name();
        String query = "DELETE FROM " + tableName + " WHERE " + where + ";";

        connection.prepareStatement(query).execute();
    }

    private boolean checkIfFieldExistsInDatabase(Field field, String tableName) throws SQLException {
        ResultSet allColumns = connection.prepareStatement(String.format("SELECT `COLUMN_NAME` AS column_name\n" +
                "FROM `INFORMATION_SCHEMA`.`COLUMNS` \n" +
                "WHERE `TABLE_SCHEMA`='%s' \n" +
                "AND `TABLE_NAME`='%s';", Connector.getDatabaseName(), tableName))
                .executeQuery();

        while (allColumns.next()) {
            String columnName = allColumns.getString("column_name");

            if (columnName.equals(field.getDeclaredAnnotation(Column.class).name())) {
                return true;
            }
        }

        return false;
    }

    private String getMySQLDataTypeFromField(Field field) {
        switch (field.getType().getSimpleName()) {
            case "int":
                return "INTEGER";
            case "String":
                return "VARCHAR(50)";
            case "Date":
                return "DATE";
        }

        return null;
    }
}