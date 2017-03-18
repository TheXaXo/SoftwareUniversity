package ListUtilities;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> elements) {
        if (elements.isEmpty()) {
            throw new IllegalArgumentException("List should not be empty!");
        }

        T min = elements.get(0);

        for (int i = 1; i < elements.size(); i++) {
            if (min.compareTo(elements.get(i)) > 0) {
                min = elements.get(i);
            }
        }

        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> elements) {
        if (elements.isEmpty()) {
            throw new IllegalArgumentException("List should not be empty!");
        }

        T max = elements.get(0);

        for (int i = 1; i < elements.size(); i++) {
            if (max.compareTo(elements.get(i)) < 0) {
                max = elements.get(i);
            }
        }

        return max;
    }
}