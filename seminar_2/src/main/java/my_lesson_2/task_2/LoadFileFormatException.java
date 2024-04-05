package my_lesson_2.task_2;

public class LoadFileFormatException extends Exception {
    private final int line; // для это мы введем счетчик counter в программе
    private final String data; // данные будем брать из parts[1] (стр. 46 program)

    public LoadFileFormatException(String message, int line, String data) {
        super(message);
        this.line = line;
        this.data = data;
    }

    public int getLine() {
        return line;
    }

    public String getData() {
        return data;
    }
}
