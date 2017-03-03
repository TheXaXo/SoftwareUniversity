package bg.softuni.exceptions;

public class InvalidNameVariableException extends RuntimeException {
    private static final String NULL_OR_EMPTY_VALUE = "The value of the variable cannot be null or empty!";

    public InvalidNameVariableException() {
        super(NULL_OR_EMPTY_VALUE);
    }

    public InvalidNameVariableException(String message) {
        super(message);
    }
}
