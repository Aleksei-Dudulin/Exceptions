import Exceptions.DateException;
import Exceptions.FullNameException;
import Exceptions.GenderException;
import Exceptions.PhoneNumberExeption;

public class CheckDataService {

    /**
     * Метод проверки данных от пользователя на различные типы исключений
     * @param dataParts данные от пользователя на проверку в виде массива строк
     * @return исходные данные, если проверка пройдена
     * @throws DateException м.б. некорректный формат даты (д.б. dd.mm.yyyy)
     * @throws PhoneNumberExeption м.б. номер телефона некорректный (д.б. беззнаковое целое число)
     * @throws GenderException м.б. некорректный пол (либо "f" либо "m")
     * @throws FullNameException м.б. некорректное ФИО
     */
    public static String[] checkDataService(String[] dataParts) throws DateException, PhoneNumberExeption, GenderException, FullNameException {

        for (int i = 0; i < 4; i++){
            switch (i){

                case 0:
                    for (int j = 0; j < 3; j++){
                        if (dataParts[j].matches(".*[^а-яА-Я].*")) {
                            throw new FullNameException("Некорректный формат ФИО.", dataParts[j]);
                        }
                    }

                case 1:
                    String[] birthdayateParts = dataParts[3].split("\\.");
                    if (birthdayateParts.length != 3 || birthdayateParts[0].length() != 2
                            || birthdayateParts[1].length() != 2
                            || birthdayateParts[2].length() != 4) {
                        throw new DateException("Некорректный формат даты рождения.", dataParts[3]);
                    };

                case 2:
                    if (!dataParts[4].matches("\\d+")){
                        throw new PhoneNumberExeption("Некорректный формат номера телефона.", dataParts[4]);
                    };

                case 3:
                    if (!dataParts[5].equals("m") && !dataParts[5].equals("f")){
                        throw new GenderException("Некорректный формат пола.", dataParts[5]);
                    };
            }
        }
        return dataParts;
    }
}
