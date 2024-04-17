package Exceptions;

public class FullNameException extends Exception {
    private final String name;

    public FullNameException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
