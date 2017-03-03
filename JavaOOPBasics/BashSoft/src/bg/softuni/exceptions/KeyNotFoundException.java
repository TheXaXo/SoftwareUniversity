package bg.softuni.exceptions;

public class KeyNotFoundException extends RuntimeException {
    private static final String STUDENT_NOT_ENROLLED = "Student must be enrolled in a course before you set his mark.";

    public KeyNotFoundException() {
        super(STUDENT_NOT_ENROLLED);
    }

    public KeyNotFoundException(String message) {
        super(message);
    }
}