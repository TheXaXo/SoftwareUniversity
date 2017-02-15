import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] flowersArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] bucketsArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> flowers = new ArrayDeque<>();
        ArrayList<Integer> bloomedFlowers = new ArrayList<>();
        ArrayDeque<Integer> buckets = new ArrayDeque<>();

        for (int flower : flowersArr) {
            flowers.add(flower);
        }

        for (int bucket : bucketsArr) {
            buckets.push(bucket);
        }

        while (true) {
            if (buckets.peek() == flowers.peek()) {
                buckets.pop();

                bloomedFlowers.add(flowers.remove());

                if (flowers.isEmpty()) {
                    printRemainingBuckets(buckets, bloomedFlowers);
                    return;
                }

                if (buckets.isEmpty()) {
                    printRemainingFlowers(flowers, bloomedFlowers);
                    return;
                }
            } else {
                if (buckets.peek() > flowers.peek()) {
                    int removedFlower = flowers.remove();
                    int leftOverCapacity = buckets.peek() - removedFlower;

                    if (buckets.size() > 1) {
                        buckets.pop();
                        int nextBucket = buckets.pop();

                        buckets.push(leftOverCapacity + nextBucket);
                    }

                    if (flowers.isEmpty()) {
                        printRemainingBuckets(buckets, bloomedFlowers);
                        return;
                    }

                    if (buckets.isEmpty()) {
                        printRemainingFlowers(flowers, bloomedFlowers);
                        return;
                    }
                } else {
                    int flowerWeiss = flowers.peek();

                    while (flowerWeiss > 0) {
                        flowerWeiss -= buckets.peek();
                        buckets.pop();

                        if (buckets.isEmpty()) {
                            printRemainingFlowers(flowers, bloomedFlowers);
                            return;
                        }
                    }

                    if (flowerWeiss == 0) {
                        bloomedFlowers.add(flowers.remove());
                    } else {
                        flowers.remove();
                    }

                    if (flowers.isEmpty()) {
                        printRemainingBuckets(buckets, bloomedFlowers);
                        return;
                    }
                }
            }
        }
    }

    private static void printRemainingBuckets(ArrayDeque<Integer> buckets, ArrayList<Integer> bloomedFlowers) {
        while (!buckets.isEmpty()) {
            System.out.print(buckets.pop() + " ");
        }

        System.out.println();

        if (bloomedFlowers.size() == 0) {
            System.out.println("None");
        } else {
            for (int flower : bloomedFlowers) {
                System.out.print(flower + " ");
            }
        }
    }

    private static void printRemainingFlowers(ArrayDeque<Integer> flowers, ArrayList<Integer> bloomedFlowers) {
        while (!flowers.isEmpty()) {
            System.out.print(flowers.remove() + " ");
        }

        System.out.println();

        if (bloomedFlowers.size() == 0) {
            System.out.println("None");
        } else {
            for (int flower : bloomedFlowers) {
                System.out.print(flower + " ");
            }
        }
    }
}