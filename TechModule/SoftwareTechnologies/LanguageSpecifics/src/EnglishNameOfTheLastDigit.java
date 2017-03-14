import java.util.Scanner;

public class EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String number = console.nextLine();

        System.out.println(GetNameOfLastDigit(number));
    }
    public static String GetNameOfLastDigit(String number) {
        String lastDigit = Character.toString(number.charAt(number.length() - 1));

        if (lastDigit.equals("0")){
            return "zero";
        }
        else if (lastDigit.equals("1")){
            return "one";
        }
        else if (lastDigit.equals("2")){
            return "two";
        }
        else if (lastDigit.equals("3")){
            return "three";
        }
        else if (lastDigit.equals("4")){
            return "four";
        }
        else if (lastDigit.equals("5")){
            return "five";
        }
        else if (lastDigit.equals("6")){
            return "six";
        }
        else if (lastDigit.equals("7")){
            return "seven";
        }
        else if (lastDigit.equals("8")){
            return "eight";
        }
        else{
            return "nine";
        }
    }
}