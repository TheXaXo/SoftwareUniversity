package highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classToInspect = Class.forName("highQualityMistakes.Reflection");

        Field[] allFields = Arrays.stream(classToInspect.getDeclaredFields())
                .sorted(Comparator.comparing(Field::getName))
                .toArray(Field[]::new);
        Method[] allGetters = Arrays.stream(classToInspect.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Method[] allSetters = Arrays.stream(classToInspect.getMethods())
                .filter(method -> method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        for (Field field : allFields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                System.out.printf("%s must be private!%n", field.getName());
            }
        }

        for (Method method : allGetters) {
            if (!Modifier.isPublic(method.getModifiers())) {
                System.out.printf("%s have to be public!%n", method.getName());
            }
        }

        for (Method method : allSetters) {
            if (!Modifier.isPrivate(method.getModifiers())) {
                System.out.printf("%s have to be private!%n", method.getName());
            }
        }
    }
}