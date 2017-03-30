package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<?> boxClass = BlackBoxInt.class;

        Constructor<?> boxConstructor = boxClass.getDeclaredConstructor();
        boxConstructor.setAccessible(true);

        Object boxInstance = boxConstructor.newInstance();

        String command = reader.readLine();

        Field fieldToPrint = boxClass.getDeclaredField("innerValue");
        fieldToPrint.setAccessible(true);

        while (!command.equals("END")) {
            String[] tokens = command.split("_");

            String methodToCall = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method methodToInvoke = boxClass.getDeclaredMethod(methodToCall, int.class);
            methodToInvoke.setAccessible(true);

            methodToInvoke.invoke(boxInstance, value);
            System.out.println(fieldToPrint.getInt(boxInstance));

            command = reader.readLine();
        }
    }
}