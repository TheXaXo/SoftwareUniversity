package app.waste_disposal.interpreters;

import java.lang.reflect.InvocationTargetException;

public interface Interpreter {

    String interpret(String command, String[] tokens) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}