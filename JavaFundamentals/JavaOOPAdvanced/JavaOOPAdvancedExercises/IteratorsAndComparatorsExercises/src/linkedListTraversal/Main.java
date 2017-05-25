package linkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomLinkedList<Integer> list = new CustomLinkedList();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");

            switch (tokens[0]) {
                case "Add":
                    list.add(Integer.parseInt(tokens[1]));
                    break;

                case "Remove":
                    list.remove(Integer.parseInt(tokens[1]));
                    break;
            }
        }

        System.out.println(list.getSize());

        for (Integer item : list) {
            System.out.print(item + " ");
        }
    }
}