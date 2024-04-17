package Exceptions;

public class GenderException extends Exception {
    private final String gender;

    public GenderException(String message, String gender) {
        super(message);
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
