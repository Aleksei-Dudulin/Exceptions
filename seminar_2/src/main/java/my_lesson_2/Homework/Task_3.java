package my_lesson_2.Homework;

/**
 * Напишите программу для выполнения арифметической операции деления двух целых чисел a и b.
 * При этом программа должна проверить, что делитель b не равен нулю, и выполнить деление только в этом случае.
 * Если b равен нулю, программа должна вернуть результат равный нулю.
 * После выполнения операции деления, программа также должна вывести сумму чисел a и b с помощью метода printSum.
 * Если аргументы не переданы через командную строку, используйте значения по умолчанию.
 */

public class Task_3 {
    public static void main(String[] args) {
        int a = 12;
        int b = 0;
        if (b == 0){
            System.out.println(0);
        } else {
            printSum(a, b);
            System.out.println(div(a, b));
        }

    }

    public static double div(int a, int b){
        return (double) a /b;
//        try{
//            return (double) a /b;
//        }
//        catch (ArithmeticException e){
//            return 0;
//        }
    }

    public static void printSum(int a, int b){
        System.out.println(a + b);
    }
}
