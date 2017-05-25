import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHTML {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = "";
            while (!"END".equals(input = reader.readLine())) {
                if (input.contains("<div")) {
                    input = convertOpeningTag(input);
                    System.out.println(input);
                } else if (input.contains("</div")) {
                    input = convertClosingTag(input);
                    System.out.println(input);
                } else {
                    System.out.println(input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String convertOpeningTag(String input) {
        int startIndex = input.indexOf("<");
        String startSpaces = new String(new char[startIndex]).replace("\0", " ");
        Pattern pattern = Pattern.compile("<div\\s*(.+?)\\s*(id|class)\\s*=\\s*\"(.*?)\"(.*)>");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            input = matcher.group(3) + " " + matcher.group(1)
                    + " " + matcher.group(4);
            Pattern spacePattern = Pattern.compile("\\s+");
            Matcher spaceMatcher = spacePattern.matcher(input);
            input = spaceMatcher.replaceAll(" ").trim();
        }
        input = startSpaces + "<" + input + ">";
        return input;
    }

    static String convertClosingTag(String input) {
        int startIndex = input.indexOf("<");
        String startSpaces = new String(new char[startIndex]).replace("\0", " ");
        Pattern pattern = Pattern.compile("<\\/div>\\s*<!--\\s*(.*?)\\s*-->");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            input = startSpaces + "</" + matcher.group(1).trim() + ">";
        }
        return input;
    }

}