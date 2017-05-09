package avatar.commands;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

    String execute() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException;
}