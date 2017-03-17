package GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {
        T[] elements = (T[]) new Object[length];

        for (int i = 0; i < length; i++) {
            elements[i] = item;
        }

        return elements;
    }

    public static <T> T[] create(Class<T> _class, int length, T item) {
        T[] elements = (T[]) Array.newInstance(_class, length);

        for (int i = 0; i < length; i++) {
            elements[i] = item;
        }

        return elements;
    }
}