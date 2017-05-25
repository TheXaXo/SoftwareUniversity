package Telephony;

public class Smartphone implements Browsable, Phonable {

    @Override
    public String phone(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Invalid number!");
            }
        }

        return String.format("Calling... %s", number);
    }

    @Override
    public String browse(String website) {
        for (char c : website.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("Invalid URL!");
            }
        }

        return String.format("Browsing: %s!", website);
    }
}