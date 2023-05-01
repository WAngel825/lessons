package ru.otus.homework.homework16.test.unit;

import ru.otus.homework.homework16.app.game.*;
import ru.otus.homework.homework16.assertions.Assertions;
import ru.otus.homework.homework16.test.unit.fakes.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DiceImplTest04 {
    public void testDiceImplN04() {
        String scenario = "V4. Тест на победителя Игоря";

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream myStream = new PrintStream(outputStream);
        System.setOut(myStream);

        Dice dice = new DiceImplFake02();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinterFake02();
        Game game = new Game(dice, winnerPrinter);

        Player expectedWinner = new Player("Игорь");
        game.playGame(new Player("Вася"), expectedWinner);

        String actual = outputStream.toString();

        System.setOut(consoleStream);

        try {
            String expected = "Игорь";
            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }


        Player actualWinner = ((GameWinnerConsolePrinterFake02) winnerPrinter).getMainPlayer();

        if (expectedWinner.equals(actualWinner)) {
            System.out.printf("\"%s\" passed %n", scenario);
        } else {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, "Одижание не совпало с реальностью");
        }


    }
}

