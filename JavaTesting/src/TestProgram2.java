import java.util.LinkedHashMap;
import java.util.Map;

public class TestProgram2 {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> nameAge = new LinkedHashMap<>();

        nameAge.put("Pesho", 3);
        nameAge.put("Ivan", 3);

        if (nameAge.containsKey("Pesho")) {
            nameAge.replace("Pesho", 2);
        }

        for (Map.Entry<String, Integer> pair : nameAge.entrySet()){
            System.out.printf("%s is %d years old", pair.getKey(), pair.getValue());
            System.out.println();
        }
    }
}
