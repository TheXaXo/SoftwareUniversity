package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        Field[] allFields = RichSoilLand.class.getDeclaredFields();

        while (!command.equals("HARVEST")) {

            if (command.equals("all")) {
                for (Field field : allFields) {
                    printField(field);
                }

                command = reader.readLine();
                continue;
            }

            String currentCommand = command;

            Arrays.stream(allFields)
                    .filter(field -> Modifier.toString(field.getModifiers()).equals(currentCommand))
                    .forEach(field -> printField(field));

            command = reader.readLine();
        }
    }

    private static void printField(Field field) {
        System.out.printf("%s %s %s%n",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),
                field.getName());
    }
}