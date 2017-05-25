package GenericAddAllMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Number> dest = new ArrayList<>();

        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 2);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 2.2, 3.3);

        List<List<? extends Number>> jaggedList = new ArrayList<>();
        Collections.addAll(jaggedList, numbers, doubles);

        ListUtils.flatten(dest, jaggedList);

        for (Number number : dest) {
            System.out.println(number);
        }
    }
}