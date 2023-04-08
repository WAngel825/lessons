package ru.otus.homework.homework16.test.unit;

import ru.otus.homework.homework16.app.game.*;
import ru.otus.homework.homework16.test.unit.fakes.*;

public class DiceImplTest04 {
    public void testDiceImplN04() {
        String scenario = "V4. Тест на победителя Игоря";

        Dice dice = new DiceImplFake02();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinterFake02();
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"), new Player("Игорь"));

    }
}

