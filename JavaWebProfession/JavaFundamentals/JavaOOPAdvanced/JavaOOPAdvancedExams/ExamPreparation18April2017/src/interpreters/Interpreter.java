package interpreters;

import java.lang.reflect.InvocationTargetException;

public interface Interpreter {

    void interpretCommand(String[] tokens) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}