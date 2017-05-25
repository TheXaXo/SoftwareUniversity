package avatar.interpreters;

import java.lang.reflect.InvocationTargetException;

public interface Interpreter {

    String interpretCommand(String[] tokens) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException;
}