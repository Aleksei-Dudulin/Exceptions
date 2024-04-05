package my_lesson_2.Homework.Task_4;

/**
 * Напишите программу, которая принимает символ a в качестве аргумента и выполняет следующую проверку:
 * если символ a равен пробелу '', программа должна выбрасывать исключение с сообщением "Пустая строка введена.".
 * В противном случае программа должна возвращать сообщение "Ваш ввод - [символ]", где [символ] заменяется на введенный символ a.
 */
public class Task_4 {
    public static void main(String[] args) {
        char a = ' ';
        try {
            System.out.println(task_4(a));
        }
        catch (IllegalArgumentException e){
            System.out.println("Пустая строка введена.");
        }
    }

    public static String task_4(char a) throws IllegalArgumentException{
        if (a == ' '){
            throw new IllegalArgumentException("Значение a не должно быть пробелом!");
        } else {
            return STR."Ваш ввод - \{a}";
        }
    }
}
