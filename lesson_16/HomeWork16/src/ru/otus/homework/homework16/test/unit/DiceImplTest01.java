package ru.otus.homework.homework16.test.unit;

import ru.otus.homework.homework16.app.game.DiceImpl;
import ru.otus.homework.homework16.assertions.Assertions;

public class DiceImplTest01 {
    private final DiceImpl diceImpl = new DiceImpl();


    public void testDiceImplN01() {
        String scenario = "V1. Тест Рандома на значение больше 6";

        try {
            int minExpected = 1;
            int maxExpected = 6;
            int actual = 1;

            for (int i = 0; i < 10000; i++) {
                actual = Math.max(actual, diceImpl.roll());
            }

            Assertions.assertEquals(minExpected, maxExpected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

    }
}
