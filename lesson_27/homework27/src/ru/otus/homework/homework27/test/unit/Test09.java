package ru.otus.homework.homework27.test.unit;

import ru.otus.homework.homework27.app.CurrencyDeclination;
import ru.otus.homework.homework27.app.MoneyInWords;
import ru.otus.homework.homework27.assertions.Assertions;
import ru.otus.homework.homework27.test.unit.fakes.CurrencyFake01;

public class Test09 {
    private final CurrencyDeclination currencyDeclination = new CurrencyFake01();
    private final MoneyInWords moneyInWords = new MoneyInWords(currencyDeclination);
    private static final String[] casesExpected = {"одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч",
            "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч"};
    public void test() {
        String scenario = "V9. Тест на вывод словами тысяч ";

        for (int i = 0; i < casesExpected.length; i++) {
            int actualInt = (i+1) * 1000;
            try {
                String actual = moneyInWords.getMoneyInWords(actualInt);
                String expected = casesExpected[i];

                Assertions.assertEquals(expected, actual);

                System.out.printf("\"%s\" passed %n", scenario + actualInt);
            } catch (Throwable e) {
                System.err.printf("\"%s\" fails with message \"%s\" %n", scenario + actualInt, e.getMessage());
            }
        }
    }
}
