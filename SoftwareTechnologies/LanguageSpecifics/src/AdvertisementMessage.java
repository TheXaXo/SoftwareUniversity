import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        String[] phrases = new String[]
                {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = new String[]
                {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[]
                {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[]
                {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random random = new Random();
        for (int i = 1; i <= n; i++){
            int phrase = random.nextInt(phrases.length);
            int event = random.nextInt(events.length);
            int author = random.nextInt(authors.length);
            int city = random.nextInt(cities.length);

            System.out.printf("%s %s %s - %s%n", phrases[phrase], events[event], authors[author], cities[city]);
        }
    }
}
