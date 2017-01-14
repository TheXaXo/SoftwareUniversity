import java.util.ArrayList;

public class TestProgram3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            numbers.add(i + 1);
        }

        int[] evenNumbers = numbers.stream().filter(n -> n % 2 == 0).mapToInt(n -> n).toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < evenNumbers.length; i++) {
            if (i == evenNumbers.length - 1) {
                sb.append(evenNumbers[i]);
                break;
            }
           sb.append(evenNumbers[i] + ", ");
        }

        System.out.println(sb.toString());
    }
}
