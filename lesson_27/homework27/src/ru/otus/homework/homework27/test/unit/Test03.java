package ru.otus.homework.homework27.test.unit;

import ru.otus.homework.homework27.app.CheckMoney;
import ru.otus.homework.homework27.assertions.Assertions;

public class Test03 {
    public void test() {
        String scenario = "V3. Тест Проверки на ввод символов ";

        try {
            String actual = CheckMoney.CheckMoney("1000000f");
            String expected = "Введеное значение не является целым числом";

            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
