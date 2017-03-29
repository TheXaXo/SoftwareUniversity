package gettersAndSetters;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class reflectionClass = Reflection.class;

        Method[] allMethods = reflectionClass.getDeclaredMethods();

        Map<String, String> getters = new HashMap<>();
        Map<String, String> setters = new HashMap<>();

        for (Method method : allMethods) {
            if (method.getName().contains("get")) {
                getters.put(method.getName(), method.getReturnType().toString());
            } else if (method.getName().contains("set")) {
                setters.put(method.getName(), method.getParameterTypes()[0].toString());
            }
        }

        getters.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(pair -> System.out.printf("%s will return %s%n", pair.getKey(), pair.getValue()));

        setters.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(pair -> System.out.printf("%s and will set field of %s%n", pair.getKey(), pair.getValue()));
    }
}