package enums;

public enum Status {

    SPECIAL("Special"), NONSPECIAL("Non-Special");

    private String type;

    Status(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}