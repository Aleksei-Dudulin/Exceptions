import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    /**
     * Метод записывает данные от пользователя, прошедшие все проверки, в файл
     * @param dataParts данные от пользователя, прошедшие все проверки
     * @throws IOException м.б. ошибка ввода-вывода при записи в файл
     */
    public static void fileService(String[] dataParts){
        String fileName = dataParts[0] + ".txt";
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))){
            for (String o: dataParts){
                fileWriter.write(o + " ");
            }
            fileWriter.newLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
