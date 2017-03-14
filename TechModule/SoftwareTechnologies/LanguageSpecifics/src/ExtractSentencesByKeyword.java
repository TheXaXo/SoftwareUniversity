import java.util.Scanner;

public class ExtractSentencesByKeyword {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String requiredWord = console.nextLine();
        String input = console.nextLine();

        String[] sentances = input.split("[\\!\\.\\?]");

        for (int i = 0; i < sentances.length; i++){
            String[] words = sentances[i].split("[^a-zA-Z]");

            for (String word : words){
                if (word.equals(requiredWord)){
                    System.out.println(sentances[i].trim());
                    break;
                }
            }
        }
    }
}