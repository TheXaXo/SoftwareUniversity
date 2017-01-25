import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] expression = console.nextLine().split(" ");

        ArrayDeque<String> operators = new ArrayDeque<>();

        for (String element : expression) {
            if ((element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) &&
                    (operators.isEmpty() || operators.peek().equals("("))) {
                operators.push(element);
            } else {
                if (element.equals("(")) {
                    operators.push("(");
                } else if (element.equals(")")) {
                    while (!operators.peek().equals("(")) {
                        System.out.print(operators.pop() + " ");
                    }

                    operators.pop();
                } else if (element.equals("*") || element.equals("/")) {
                    if (operators.peek().equals("+") || operators.peek().equals("-") || operators.peek().equals("(")) {
                        operators.push(element);
                    } else {
                        while (!operators.isEmpty() &&
                                !operators.peek().equals("+") &&
                                !operators.peek().equals("-") &&
                                !operators.peek().equals("(")) {
                            System.out.print(operators.pop() + " ");
                        }

                        operators.push(element);
                    }
                } else if (element.equals("+") || element.equals("-")) {
                    while (!operators.isEmpty() && !operators.peek().equals("(")) {
                        System.out.print(operators.pop() + " ");
                    }

                    operators.push(element);
                } else {
                    System.out.print(element + " ");
                }
            }
        }

        while (!operators.isEmpty()) {
            System.out.print(operators.pop() + " ");
        }
    }
}