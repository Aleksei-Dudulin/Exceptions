package Exceptions;

public class PhoneNumberExeption extends Exception {
    private final String number;

    public PhoneNumberExeption(String message, String number) {
        super(message);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
