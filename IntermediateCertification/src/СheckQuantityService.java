import Exceptions.QuantityExeption;


public class СheckQuantityService {
    /**
     * Метод для подсчета количества аргументов с разделителем " " в
     * строке массива {Фамилия Имя Отчество дата_рождения номер_телефона пол}
     * @param data данные от пользователя на проверку в виде массива строк
     * @return исходные данные, если проверка пройдена
     * @throws QuantityExeption м.б. некорректное количество частей в строке данных (д.б. 6)
     */
    public static String[] checkQuantityService(String[] data) throws QuantityExeption {
        if (data.length != 6) {
            throw new QuantityExeption("Некорректное количество данных.",
                    (Integer) data.length);
        } else {
            return data;
        }
    }
}
