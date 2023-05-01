package ru.otus.homework.homework16.test.unit;

import ru.otus.homework.homework16.app.game.*;
import ru.otus.homework.homework16.assertions.Assertions;
import ru.otus.homework.homework16.test.unit.fakes.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DiceImplTest03 {
    public void testDiceImplN03() {
        String scenario = "V3. Тест на ничью";

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream myStream = new PrintStream(outputStream);
        System.setOut(myStream);

        Dice dice = new DiceImplFake01();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinterFake01();
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"), new Player("Игорь"));

        String actual = outputStream.toString().toLowerCase();

        System.setOut(consoleStream);

        try {

            String expected = "ничья";
            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        Player expectedWinner = null;
        Player actualWinner = ((GameWinnerConsolePrinterFake01) winnerPrinter).getMainPlayer();

        if (expectedWinner == actualWinner) {
            System.out.printf("\"%s\" passed %n", scenario);
        } else {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, "Одижание не совпало с реальностью");
        }

    }
}

