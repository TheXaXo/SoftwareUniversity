import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int smallCount = 0;
        int mediumCount = 0;
        int largeCount = 0;

        Pattern p = Pattern.compile("(?:(>----->)|(>>----->)|(>>>----->>))");

        for (int i = 0; i < 4; i++) {
            Matcher m = p.matcher(reader.readLine());

            while (m.find()) {
                if (m.group(3) != null) {
                    largeCount++;
                } else if (m.group(2) != null) {
                    mediumCount++;
                } else if (m.group(1) != null) {
                    smallCount++;
                }
            }
        }

        String numberConcat = Integer.toString(smallCount) + Integer.toString(mediumCount) + Integer.toString(largeCount);
        String binary = Integer.toBinaryString(Integer.parseInt(numberConcat));
        binary = binary.concat(new StringBuilder(binary).reverse().toString());

        int result = Integer.parseInt(binary, 2);
        System.out.println(result);
    }
}