package P01_ExtendedArrayList;

import java.util.ArrayList;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> {

    public T min() {
        T min = null;

        for (T element : this) {
            if (min == null || element.compareTo(min) < 0) {
                min = element;
            }
        }

        return min;
    }

    public T max() {
        T max = null;

        for (T element : this) {
            if (max == null || element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }
}