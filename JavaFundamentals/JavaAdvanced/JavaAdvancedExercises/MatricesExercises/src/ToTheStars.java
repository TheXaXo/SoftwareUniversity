import java.util.Scanner;

public class ToTheStars {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Star[] stars = new Star[3];

        for (int i = 0; i < 3; i++) {
            String[] starArgs = console.nextLine().split("\\s");

            double x = Double.parseDouble(starArgs[1]);
            double y = Double.parseDouble(starArgs[2]);

            Star star = new Star();

            star.name = starArgs[0];

            star.bottomY = y - 1;
            star.topY = y + 1;
            star.leftX = x - 1;
            star.rightX = x + 1;

            stars[i] = star;
        }

        String[] split = console.nextLine().split("\\s");

        double playerX = Double.parseDouble(split[0]);
        double playerY = Double.parseDouble(split[1]);

        int n = Integer.parseInt(console.nextLine());

        boolean hasEntered = false;

        for (int i = 0; i <= n; i++) {
            for (Star star : stars) {
                String name = star.name;
                if (playerX >= star.leftX && playerX <= star.rightX
                        && playerY >= star.bottomY && playerY <= star.topY) {
                    System.out.println(star.name.toLowerCase());
                    hasEntered = true;
                    break;
                }
            }

            if (!hasEntered) {
                System.out.println("space");
            }

            playerY++;
            hasEntered = false;
        }
    }
}

class Star {
    String name;
    double bottomY;
    double topY;
    double leftX;
    double rightX;
}