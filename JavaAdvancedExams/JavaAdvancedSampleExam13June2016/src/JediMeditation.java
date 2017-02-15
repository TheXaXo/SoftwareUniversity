import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JediMeditation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> masters = new ArrayList<>();
        ArrayList<String> knights = new ArrayList<>();
        ArrayList<String> padawans = new ArrayList<>();

        ArrayList<String> specialPadawans = new ArrayList<>();
        boolean thereIsMasterYoda = false;

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] jedis = reader.readLine().split(" ");

            for (String jedi : jedis) {
                if (jedi.charAt(0) == 'm') {
                    masters.add(jedi);
                } else if (jedi.charAt(0) == 'k') {
                    knights.add(jedi);
                } else if (jedi.charAt(0) == 'p') {
                    padawans.add(jedi);
                } else if (jedi.charAt(0) == 't') {
                    specialPadawans.add(jedi);
                } else if (jedi.charAt(0) == 's') {
                    specialPadawans.add(jedi);
                } else if (jedi.charAt(0) == 'y') {
                    thereIsMasterYoda = true;
                }
            }
        }

        if (!thereIsMasterYoda) {
            for (String specialPadawan : specialPadawans) {
                System.out.print(specialPadawan + " ");
            }
        }

        for (String master : masters) {
            System.out.print(master + " ");
        }

        for (String knight : knights) {
            System.out.print(knight + " ");
        }

        if (thereIsMasterYoda) {
            for (String specialPadawan : specialPadawans) {
                System.out.print(specialPadawan + " ");
            }
        }

        for (String padawan : padawans) {
            System.out.print(padawan + " ");
        }
    }
}