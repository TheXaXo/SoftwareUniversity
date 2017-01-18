import java.util.Scanner;

public class GameOfNames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int count = Integer.parseInt(console.nextLine());

        int maxScore = Integer.MIN_VALUE;
        String maxScorePlayer = "";

        for (int i = 0; i < count; i++) {
            String name = console.nextLine();
            int score = Integer.parseInt(console.nextLine());

            for (char c : name.toCharArray()) {
                if (c % 2 == 0) {
                    score += c;
                } else {
                    score -= c;
                }
            }

            if (score > maxScore) {
                maxScore = score;
                maxScorePlayer = name;
            }
        }

        System.out.printf("The winner is %s - %d points", maxScorePlayer, maxScore);
    }
}