package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TextEditor textEditor = new TextEditorImpl();

        String command = reader.readLine();
        Pattern prependPattern = Pattern.compile(".+?\\s.+?\\s\"(.+?)\"");
        Pattern insertPattern = Pattern.compile(".+?\\s.+?\\s\\d+?\\s\"(.+?)\"");

        while (!command.equals("end")) {
            String[] commandSplit = command.split(" ");

            try {
                switch (commandSplit[0]) {
                    case "login":
                        textEditor.login(commandSplit[1]);
                        break;
                    case "logout":
                        textEditor.logout(commandSplit[1]);
                        break;
                    case "users":
                        if (commandSplit.length == 1) {
                            for (String username : textEditor.users("")) {
                                System.out.println(username);
                            }

                            break;
                        }

                        for (String username : textEditor.users(commandSplit[1])) {
                            System.out.println(username);
                        }

                        break;
                    default:
                        String username = commandSplit[0];

                        switch (commandSplit[1]) {
                            case "insert":
                                Matcher insertMatcher = insertPattern.matcher(command);

                                if (!insertMatcher.matches()) {
                                    break;
                                }

                                textEditor.insert(username, Integer.parseInt(commandSplit[2]), insertMatcher.group(1));
                                break;
                            case "prepend":
                                Matcher prependMatcher = prependPattern.matcher(command);

                                if (!prependMatcher.matches()) {
                                    break;
                                }

                                textEditor.prepend(username, prependMatcher.group(1));
                                break;
                            case "substring":
                                textEditor.substring(username, Integer.parseInt(commandSplit[2]), Integer.parseInt(commandSplit[3]));
                                break;
                            case "delete":
                                textEditor.delete(username, Integer.parseInt(commandSplit[2]), Integer.parseInt(commandSplit[3]));
                                break;
                            case "clear":
                                textEditor.clear(username);
                                break;
                            case "length":
                                System.out.println(textEditor.length(username));
                                break;
                            case "print":
                                System.out.println(textEditor.print(username));
                                break;
                            case "undo":
                                textEditor.undo(username);
                                break;
                        }
                }
            } catch (Exception ignored) {

            }

            command = reader.readLine();
        }
    }
}