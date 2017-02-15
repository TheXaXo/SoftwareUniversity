import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        LinkedHashSet<String> uniqueUsernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            uniqueUsernames.add(console.nextLine());
        }

        for (String username : uniqueUsernames) {
            System.out.println(username);
        }
    }
}