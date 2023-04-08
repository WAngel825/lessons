package ru.otus.homework.homework16.test.unit;

import ru.otus.homework.homework16.app.game.*;
import ru.otus.homework.homework16.test.unit.fakes.*;

public class DiceImplTest03 {
    public void testDiceImplN03() {
        String scenario = "V3. Тест на ничью";

        Dice dice = new DiceImplFake01();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinterFake01();
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"), new Player("Игорь"));

    }
}

