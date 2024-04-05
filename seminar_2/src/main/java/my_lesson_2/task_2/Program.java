package my_lesson_2.task_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Program {
    /**
     * Задача 3
     * ========
     * Запишите в файл следующие строки:
     * <p>
     * Анна=4
     * Елена=5
     * Марина=6
     * Владимир=?
     * Константин=?
     * Иван=4
     * <p>
     * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если
     * студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, если сохранено
     * значение ?, заменить его на соответствующее число. Если на каком-то месте встречается символ, отличный от
     * числа или ?, бросить подходящее исключение.
     */

    public static void main(String[] args) {
        prepareFile();
        try {
            Map<String, Integer> map = loadFile();
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                System.out.printf("%s - %d\n", e.getKey(), e.getValue());
            }
        } catch (LoadFileFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Строка в файле: " + e.getLine());
            System.out.println("Ожидали кол-во символов или знак \"?\", а получили: " + e.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Map<String, Integer> loadFile() throws IOException, LoadFileFormatException {
        String line;
        int counter = 0;
        Map<String, Integer> map = new LinkedHashMap<>(); // LinkedHashMap чтобы список в нашем объекте map был в
        // такой же последовательности как и в самом файле
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D://Программирование/2. Специализация/Exceptions/seminar_2/src/main/java/my_lesson_2/task_2/task_2.txt"))) {
            while ((line = bufferedReader.readLine()) != null) {
                counter++;
                String[] parts = line.split("=");
                try {
                    map.put(parts[0], parts[1].length() == 1
                            && parts[1].charAt(0) == '?' ? parts[0].length() : Integer.parseInt(parts[1]));
                } catch (NumberFormatException e) {
                    throw new LoadFileFormatException("Исключение при обработке данных", counter, parts[1]);
                }
            }
        }

        /**
         * Если в методе loadFile какое-либо исключение произойдет, то поток не будет закрыт,
         * поэтому кладем bufferedReader в try with resources перед запуском и
         * тогда закрывать поток с помощью .close вручную не нужно.
         */
//        bufferedReader.close();
        return map;
    }

    private static Random random = new Random();
    static void prepareFile() {
//        FileWriter task_2 = null; // убираем потому что в итоге пользуемся try with resources
        try (FileWriter task_2 = new FileWriter("D://Программирование/2. Специализация/Exceptions/seminar_2/src/main/java/my_lesson_2/task_2/task_2.txt")) {
//            FileWriter task_2 = new FileWriter("task_2"); // если прописать в блоке try, то он будет доступен только в блоке try
//            task_2 = new FileWriter("task_2"); // в строке 32 мы просто объявляем task_2, не инициализируя ее значение
            task_2.write("Анна=4\n");
            task_2.write("Елена=?\n");
            task_2.write("Марина=ААААА\n");
//            if (random.nextInt(2) == 0){
//                throw new Exception("Error!");
//            }
            task_2.write("Владимир=?\n");
            task_2.write("Константин=?\n");
            task_2.write("Иван=4\n");
//            task_2.close(); // переносим в finally, чтобы поток с файлом был 100% закрыт несмотря на все exceptions
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // можем убрать, потому что при использовании try with resources все что передается в () в блоке try? автоматически закрывается при выходе из этого блока
        /*finally {
            try{
                task_2.close(); // при вызове метода .close может возникнуть исключение
            }
            catch (IOException e){ //
                e.printStackTrace();
            }
        }*/
    }
}
