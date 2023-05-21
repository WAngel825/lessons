package ru.otus.homework.homework27.test.unit;

import ru.otus.homework.homework27.app.CurrencyDeclination;
import ru.otus.homework.homework27.app.MoneyInWords;
import ru.otus.homework.homework27.assertions.Assertions;
import ru.otus.homework.homework27.test.unit.fakes.CurrencyFake01;

public class Test05 {
    private final CurrencyDeclination currencyDeclination = new CurrencyFake01();
    private final MoneyInWords moneyInWords = new MoneyInWords(currencyDeclination);
    private static final String[] casesExpected = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    public void test() {
        String scenario = "V5. Тест на вывод словами цифры ";

        for (int i = 0; i < casesExpected.length; i++) {
            try {
                String actual = moneyInWords.getMoneyInWords(i);
                String expected = casesExpected[i];

                Assertions.assertEquals(expected, actual);

                System.out.printf("\"%s\" passed %n", scenario + i);
            } catch (Throwable e) {
                System.err.printf("\"%s\" fails with message \"%s\" %n", scenario + i, e.getMessage());
            }
        }
    }
}
