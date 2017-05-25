package GenericFlatMethod;

import java.util.ArrayList;
import java.util.Collections;
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

    public static <T> List<Integer> getNullIndices(List<T> elements) {
        List<Integer> indexesOfNullElements = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == null) {
                indexesOfNullElements.add(i);
            }
        }

        return indexesOfNullElements;
    }

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> source) {
        for (List<? extends T> innerList : source) {
            destination.addAll(innerList);
        }
    }
}