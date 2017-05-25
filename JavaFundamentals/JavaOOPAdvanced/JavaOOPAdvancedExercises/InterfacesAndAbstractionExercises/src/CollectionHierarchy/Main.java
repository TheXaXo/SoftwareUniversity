package CollectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        String[] items = reader.readLine().split(" ");

        for (String item : items) {
            System.out.print(addCollection.add(item) + " ");
        }
        System.out.println();
        for (String item : items) {
            System.out.print(addRemoveCollection.add(item) + " ");
        }
        System.out.println();
        for (String item : items) {
            System.out.print(myList.add(item) + " ");
        }
        System.out.println();

        int removeOperations = Integer.parseInt(reader.readLine());

        for (int i = 0; i < removeOperations; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();
        for (int i = 0; i < removeOperations; i++) {
            System.out.print(myList.remove() + " ");
        }
    }
}