package my_lesson_2.task_1;

import java.util.Random;

public class Program {
    /*
     1.  Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
     При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     2.  Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
     Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
     3.  В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
     MyArrayDataException и вывести результат расчета.

    */
    public static Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            testArray();
        }
    }

    /**
     * Метод для тестирования работы приложения.
     */
    public static void testArray(){
        try {
            System.out.printf("Сумма элементов массива %d\n", sumElement(generateArray()));
        } catch (MyArrayDataException e) {
            System.out.printf("%s по индексу [%d][%d]\n", e.getMessage(), e.getX(), e.getY());
        } catch (MyArraySizeException e) {
            System.out.printf("%s, требовалось получить массив [4х4], а получили [%dx%d]\n", e.getMessage(), e.getX(), e.getY());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static String[][] generateArray(){
        int add = random.nextInt(2); // создаем переменную для генерации массива с вероятностными размерами
        String[][] array = new String[add + 4][add + 4];

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                array[i][j] = Integer.toString(random.nextInt(10, 100));
            }
        }

        if (random.nextInt(3) == 0){
            array[random.nextInt(array.length)][random.nextInt(array.length)] = "abc";
        }

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){ // проверить работу с 0
                System.out.printf("%s\t", array[i][j]);
            }
            System.out.println();
        }
        return array;
    }

    /**
     * Метод суммирует элементы массива
     * @param array двумерный массив
     * @return сумму элементов массива
     * @throws MyArraySizeException некорректный размер массива
     * @throws MyArrayDataException некорректный формат данных
     */
    public static int sumElement(String[][] array) throws MyArraySizeException, MyArrayDataException{

        if (array == null){
            throw new IllegalArgumentException();
        }

        if (array.length != 4 || array[0].length != 4){
            throw new MyArraySizeException("Некорректный размер массива", array.length, array[0].length);
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += parseElement(array[i][j], i, j);
            }
        }
        return sum;
    }

    /**
     * Метод преобразования строки в целое число
     * @param s строка для преобразования
     * @param x координата строки в массиве по х
     * @param y координата строки в массиве по y
     * @return преобразованную в целое число строку
     * @throws MyArrayDataException некорректный формат данных
     */
    private static int parseElement(String s, int x, int y) throws MyArrayDataException{
        // Обрабатываем исключение NumberFormatException, т.к. оно вызывается у метода parseInt, а по условию задачи
        // нам нужно исключение MyArrayDataException, поэтому мы поглощаем NumberFormatException блоком try-catch.
        try{
            return Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            throw new MyArrayDataException("Некорректный формат данных в элементе массива", x, y);
        }
    }
}

