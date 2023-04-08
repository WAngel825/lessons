package ru.otus.homework.homework16.test.unit.fakes;

import ru.otus.homework.homework16.app.game.GameWinnerPrinter;
import ru.otus.homework.homework16.app.game.Player;
import ru.otus.homework.homework16.assertions.Assertions;

public class GameWinnerConsolePrinterFake01 implements GameWinnerPrinter {
    @Override
    public void printWinner(Player winner) {
        String scenario = "V3. Тест на ничью";

        try {

            String expected = "ничья";
            String actual = winner.getName().toLowerCase();
            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

    }
}
