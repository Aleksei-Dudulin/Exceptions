package Exceptions;

import java.util.zip.DataFormatException;

public class DateException extends DataFormatException {
    private final String date;

    public DateException(String message, String date) {
        super(message);
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}