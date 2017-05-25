import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        StringBuilder sb = new StringBuilder();

        ArrayDeque<StringBuilder> history = new ArrayDeque<>();
        history.push(new StringBuilder(sb));

        for (int i = 0; i < n; i++) {
            String[] commandArgs = console.nextLine().split(" ");

            switch (commandArgs[0]) {
                case "1":
                    String stringToAppend = commandArgs[1];
                    sb.append(stringToAppend);

                    history.push(new StringBuilder(sb));
                    break;

                case "2":
                    int itemsToDelete = Integer.parseInt(commandArgs[1]);

                    if (itemsToDelete > sb.length()) {
                        itemsToDelete = sb.length();
                    }

                    sb.delete(sb.length() - itemsToDelete, sb.length());

                    history.push(new StringBuilder(sb));
                    break;

                case "3":
                    int charToPrint = Integer.parseInt(commandArgs[1]);

                    System.out.println(sb.charAt(charToPrint - 1));
                    break;

                case "4":
                    history.pop();

                    sb = new StringBuilder(history.peek());
            }
        }
    }
}