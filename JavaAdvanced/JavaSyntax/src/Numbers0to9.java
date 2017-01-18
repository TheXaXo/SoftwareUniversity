public class Numbers0to9 {
    public static void main(String[] args) {
        int number = 0;

        while (true) {
            System.out.printf("Number: %d%n", number);

            number++;

            if (number == 10) {
                break;
            }
        }
    }
}