import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SecondNature {
    public static void main(String[] args) {
        // 30/100 Points

        Scanner console = new Scanner(System.in);

        ArrayList<Integer> flowers = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> buckets = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> secondNatureFlowers = new ArrayList<>();

        boolean hasShifted = false;

        for (int i = 0; i <= flowers.size(); i++) {
            if (hasShifted) {
                i--;

                hasShifted = false;
            } else if (flowers.size() == i) {
                break;
            }
            for (int j = buckets.size() - 1; j >= 0; j--) {
                int flower = flowers.get(i);
                int bucket = buckets.get(j);

                if (bucket - flower > 0) {
                    flowers.remove(i);
                    hasShifted = true;

                    if (buckets.size() > 1) {
                        buckets.set(j - 1, buckets.get(j - 1) + bucket - flower);
                        buckets.remove(j);
                    } else {
                        buckets.set(j, bucket - flower);
                    }

                    break;
                } else if (bucket - flower == 0) {
                    buckets.remove(j);
                    secondNatureFlowers.add(flowers.get(i));

                    break;
                } else {
                    buckets.remove(j);
                }
            }

            if (buckets.size() == 0) {
                break;
            }
        }

        if (flowers.size() == secondNatureFlowers.size()) {
            for (int i = buckets.size() - 1; i >= 0; i--) {
                System.out.printf("%d ", buckets.get(i));
            }
        } else {
            flowers.stream().forEach(a -> System.out.printf("%d ", a));
        }

        if (secondNatureFlowers.size() == 0) {
            System.out.printf("%nNone");
        } else {
            secondNatureFlowers.stream().forEach(a -> System.out.printf("%n%d ", a));
        }
    }
}