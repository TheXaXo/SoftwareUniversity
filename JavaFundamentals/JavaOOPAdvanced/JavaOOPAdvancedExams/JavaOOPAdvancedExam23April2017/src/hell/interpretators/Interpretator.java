package hell.interpretators;

import java.lang.reflect.InvocationTargetException;

public interface Interpretator {

    String interpret(String command, String[] tokens) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException;
}