import java.util.ArrayDeque;
import java.util.Scanner;

public class EvaluateExpression {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] expression = console.nextLine().split(" ");

        StringBuilder postFix = new StringBuilder();

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
                        postFix.append(operators.pop());
                        postFix.append(" ");
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
                            postFix.append(operators.pop());
                            postFix.append(" ");
                        }

                        operators.push(element);
                    }
                } else if (element.equals("+") || element.equals("-")) {
                    while (!operators.isEmpty() && !operators.peek().equals("(")) {
                        postFix.append(operators.pop());
                        postFix.append(" ");
                    }

                    operators.push(element);
                } else {
                    postFix.append(element);
                    postFix.append(" ");
                }
            }
        }

        while (!operators.isEmpty()) {
            postFix.append(operators.pop());
            postFix.append(" ");
        }

        ArrayDeque<Double> numbers = new ArrayDeque<>();
        String[] split = postFix.toString().split(" ");

        for (String element : split) {
            if (!element.equals("+") && !element.equals("-") && !element.equals("*") && !element.equals("/")) {
                numbers.push(Double.parseDouble(element));
            } else {
                double secondNum = numbers.pop();
                double firstNum = numbers.pop();

                switch (element) {
                    case "+":
                        numbers.push(firstNum + secondNum);
                        break;

                    case "-":
                        numbers.push(firstNum - secondNum);
                        break;

                    case "*":
                        numbers.push(firstNum * secondNum);
                        break;

                    case "/":
                        numbers.push(firstNum / secondNum);
                        break;
                }
            }
        }

        System.out.printf("%.2f", numbers.pop());
    }
}