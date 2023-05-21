package ru.otus.homework.homework27.test.unit;

import ru.otus.homework.homework27.app.CheckMoney;
import ru.otus.homework.homework27.assertions.Assertions;

public class Test02 {

    public void test() {
        String scenario = "V2. Тест Проверки ограничения на ввод числа большего 999 999 ";

        try {
            String actual = CheckMoney.CheckMoney("1000000");
            String expected = "Введенное число больше 999 999";

            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

    }
}
