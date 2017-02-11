package Repository;

import IO.OutputWriter;

import java.util.*;
import java.util.stream.Collectors;

public class RepositorySorters {

    public static void printSortedStudents(
            HashMap<String, ArrayList<Integer>> courseData,
            String comparisonType, int numberOfStudents) {

        Comparator<Map.Entry<String, ArrayList<Integer>>> comparator = (x, y) ->
                Double.compare(
                        x.getValue().stream().mapToInt(a -> a).average().orElse(0),
                        y.getValue().stream().mapToInt(a -> a).average().orElse(0));

        List<String> sortedStudents = courseData.entrySet().stream()
                .sorted(comparator)
                .limit(numberOfStudents)
                .map(x -> x.getKey())
                .collect(Collectors.toList());

        if (comparisonType.equals("descending")) {
            Collections.reverse(sortedStudents);
        }

        for (String student : sortedStudents) {
            OutputWriter.printStudent(student, courseData.get(student));
        }
    }
}