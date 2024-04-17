import Exceptions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
 * Фамилия Имя Отчество дата _ рождения номер _ телефона пол
 * <p>
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * дата _ рождения - строка формата dd.mm.yyyy
 * номер _ телефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * <p>
 * Приложение должно проверить введенные данные по количеству. Если количество не совпадает, вернуть код ошибки,
 * обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 * Приложение должно распарсить полученную строку и выделить из них требуемые значения.
 * Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
 * Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
 * пользователю выведено сообщение с информацией, что именно неверно.
 * <p>
 * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны
 * записаться полученные данные, вида <Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>
 * <p>
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
 * пользователь должен увидеть стектрейс ошибки.
 */

public class Program {
    public static void main(String[] args) {

        System.out.println("Введите данные в формате Фамилия Имя Отчество дата _ рождения номер _ телефона пол");

        try (Scanner scanner = new Scanner(System.in)) {

            String[] dataParts = CheckDataService.checkDataService(СheckQuantityService
                    .checkQuantityService(scanner.nextLine().split(" ")));
            FileService.fileService(dataParts);

        } catch (QuantityExeption e) {
            System.out.printf("%s Ожидалось 6 частей, получили %d", e.getMessage(), e.getQuantity());
        } catch (FullNameException e) {
            System.out.printf("%s Ожидалось Фамилия Имя Отчество, получили %s", e.getMessage(), e.getName());
        } catch (DateException e) {
            System.out.printf("%s Ожидалось dd.mm.yyyy, получили %s", e.getMessage(), e.getDate());
        } catch (PhoneNumberExeption e) {
            System.out.printf("%s Ожидалось целое беззнаковое число без форматирования, получили %s",
                    e.getMessage(), e.getNumber());
        } catch (GenderException e) {
            System.out.printf("%s Ожидался символ латиницей f или m, получили %s", e.getMessage(), e.getGender());
        }
    }
}
