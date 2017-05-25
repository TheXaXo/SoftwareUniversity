package Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    private List<Integer> numbers;

    public Lake() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(int number) {
        this.numbers.add(number);
    }

    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {

        private int index;
        private boolean isOnOdd;

        public Frog() {
            this.index = 0;
            this.isOnOdd = false;
        }

        @Override
        public boolean hasNext() {
            if (isOnOdd && index > numbers.size() - 1) {
                return false;
            } else if (!isOnOdd && index > numbers.size() - 1) {
                this.index = 1;

                if (this.index > numbers.size() - 1) {
                    return false;
                }

                this.isOnOdd = true;

                return true;
            } else {
                return true;
            }
        }

        @Override
        public Integer next() {
            int indexToGet = this.index;
            this.index += 2;

            return numbers.get(indexToGet);
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for (int number : this) {
            out.append(number).append(", ");
        }

        return out.substring(0, out.length() - 2);
    }
}