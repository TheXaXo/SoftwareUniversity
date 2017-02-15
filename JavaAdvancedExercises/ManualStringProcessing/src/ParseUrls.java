import java.util.Scanner;

public class ParseUrls {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        String[] protocolSplit = input.split("://");

        if (protocolSplit.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        String protocol = protocolSplit[0];

        int indexOfFirstDash = protocolSplit[1].indexOf("/");

        String server = protocolSplit[1].substring(0, indexOfFirstDash);
        String resources = protocolSplit[1].substring(indexOfFirstDash + 1);

        System.out.printf("Protocol = %s%nServer = %s%nResources = %s%n", protocol, server, resources);
    }
}