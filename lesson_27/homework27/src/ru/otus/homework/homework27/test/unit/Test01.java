package ru.otus.homework.homework27.test.unit;

import ru.otus.homework.homework27.app.RubCurrencyDeclination;
import ru.otus.homework.homework27.assertions.Assertions;

public class Test01 {
    private final RubCurrencyDeclination rubCurrencyDeclination = new RubCurrencyDeclination();
    private static final String[] casesExpected = {"рублей", "рубль", "рубля", "рубля", "рубля", "рублей", "рублей", "рублей", "рублей", "рублей"};

    public void test() {
        String scenario = "V1. Тест Вывода верного падежа валюты Рубль для цифры ";

        for (int i = 0; i < casesExpected.length; i++) {
            try {
                String actual = rubCurrencyDeclination.getCurrencyDeclination(i);
                String expected = casesExpected[i];

                Assertions.assertEquals(expected, actual);

                System.out.printf("\"%s\" passed %n", scenario + i);
            } catch (Throwable e) {
                System.err.printf("\"%s\" fails with message \"%s\" %n", scenario + i, e.getMessage());
            }
        }
    }
}
