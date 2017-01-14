public class TestProgram1 {
    public static void main(String[] args) {
        int[] numbers = new int[5];

        for (int i = 1; i <= 5; i++) {
            numbers[i - 1] = i;
        }

        String numbersAppended = joinNumArray(numbers);

        System.out.println(numbersAppended);
    }

    public static String joinNumArray (int[] array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                sb.append(i);
                break;
            }
            sb.append(i + ", ");
        }

        return sb.toString();
    }
}