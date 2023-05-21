package ru.otus.homework.homework27.test.unit;

import ru.otus.homework.homework27.app.CheckMoney;
import ru.otus.homework.homework27.app.CurrencyDeclination;
import ru.otus.homework.homework27.app.MoneyInWords;
import ru.otus.homework.homework27.app.RubCurrencyDeclination;
import ru.otus.homework.homework27.assertions.Assertions;

public class Test04 {
    private final CurrencyDeclination currencyDeclination = new RubCurrencyDeclination();
    private final MoneyInWords moneyInWords = new MoneyInWords(currencyDeclination);
    public void test() {
        String scenario = "V4. Тест на вывод числа 45 словами ";

        try {
            String actual = moneyInWords.getMoneyInWords(45);
            String expected = "сорок пять рублей";

            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
