package my_lesson_2.Homework.Task_2;

/**
 * Напишите программу, которая вычисляет значение выражения intArray[8] / d, где intArray- массив целых чисел, а d - делитель.
 * Программа проверяет, имеется ли в массиве intArray элемент с индексом 8, и если нет, выводит сообщение о невозможности выполнения операции.
 * Также программа проверяет, равен ли делитель d нулю, и если да, выводит соответствующее сообщение.
 */

public class Task_2 {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int d = 0;
        try {
            System.out.printf(STR."intArray[8] / d = \{intArray[8]} / \{d} = \{task_2(intArray, d)}");
            System.out.printf("intArray[8] = " + intArray[8] + "\n");

        } catch (ArithmeticException e) {
            if (intArray[0] == 0){
                System.out.println("It's not possible to evaluate the expression - intArray[8] / d as d = 0.\nNaN");
            } else {
                System.out.println("It's not possible to evaluate the expression - intArray[8] / d as d = 0.");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("It's not possible to evaluate the expression - intArray[8] / d as there is no 8th element in the given array.");
        }
    }

    public static double task_2(int[] array, int d) throws ArithmeticException, ArrayIndexOutOfBoundsException{
        if (array.length < 9){
            throw new ArrayIndexOutOfBoundsException("Массив имеет меньше 9 элементов!");
        }
        if (d == 0){
            throw new ArithmeticException("Деление на 0 невозможно!");
        } else {
            return (double) array[8] /d;
        }
    }
}
