import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputOne = console.nextLine().split(" ");
        String[] inputTwo = console.nextLine().split(" ");

        for (int i = 0; i < Math.min(inputOne.length, inputTwo.length); i++){
            if (inputOne[i].charAt(0) < inputTwo[i].charAt(0)){
                PrintArray(inputOne);
                PrintArray(inputTwo);
                return;
            }
            else if (inputOne[i].charAt(0) > inputTwo[i].charAt(0)){
                PrintArray(inputTwo);
                PrintArray(inputOne);
                return;
            }
        }

        if (inputOne.length < inputTwo.length){
            PrintArray(inputOne);
            PrintArray(inputTwo);
        }
        else{
            PrintArray(inputTwo);
            PrintArray(inputOne);
        }
    }
    public static void PrintArray(String[] array){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++){
            sb.append(array[i]);
        }

        System.out.println(sb);
    }
}