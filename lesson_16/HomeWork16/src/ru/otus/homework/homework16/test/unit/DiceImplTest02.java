package ru.otus.homework.homework16.test.unit;

import ru.otus.homework.homework16.app.game.DiceImpl;
import ru.otus.homework.homework16.assertions.Assertions;

public class DiceImplTest02 {
    private final DiceImpl diceImpl = new DiceImpl();


    public void testDiceImplN02() {
        String scenario = "V2. Тест Рандома на значение меньше 1";

        try {
            int minExpected = 1;
            int maxExpected = 6;
            int actual = 1;

            for (int i = 0; i < 10000; i++) {
                actual = Math.min(actual, diceImpl.roll());
            }

            Assertions.assertEquals(minExpected, maxExpected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

    }
}
