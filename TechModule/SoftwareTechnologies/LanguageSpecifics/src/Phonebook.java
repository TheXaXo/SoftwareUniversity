import java.util.Dictionary;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, String> nameAndPhone = new LinkedHashMap<String, String>();

        String command = console.nextLine();
        while (!command.equals("END")){
            String[] split = command.split(" ");

            if (split[0].equals("A")){
                nameAndPhone.put(split[1], split[2]);
            }
            else if (split[0].equals("S")){
                if (nameAndPhone.containsKey(split[1])){
                    System.out.println(split[1] + " -> " + nameAndPhone.get(split[1]));
                }
                else{
                    System.out.println("Contact " + split[1] + " does not exist.");
                }
            }

            command = console.nextLine();
        }
    }
}
