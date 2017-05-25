package GenericCountMethodString;

import java.util.List;

public class Count {

    public static <T extends Comparable<T>> int getCountOfGreater(List<T> elements, T element) {
        int count = 0;

        for (T currentElement : elements) {
            if (element.compareTo(currentElement) < 0) {
                count++;
            }
        }

        return count;
    }
}