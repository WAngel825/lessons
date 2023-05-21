package ru.otus.homework.homework27.test.unit;

import ru.otus.homework.homework27.app.CurrencyDeclination;
import ru.otus.homework.homework27.app.MoneyInWords;
import ru.otus.homework.homework27.app.RubCurrencyDeclination;
import ru.otus.homework.homework27.assertions.Assertions;
import ru.otus.homework.homework27.test.unit.fakes.CurrencyFake01;

public class Test10 {
    private final CurrencyDeclination currencyDeclination = new RubCurrencyDeclination();
    private final MoneyInWords moneyInWords = new MoneyInWords(currencyDeclination);
    public void test(int actualInt, String expected) {
        String scenario = "V10. Проверка входящего числа словами ";
        try {
            String actual = moneyInWords.getMoneyInWords(actualInt);
            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario + actualInt);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario + actualInt, e.getMessage());
        }




    }
}
