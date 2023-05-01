package ru.otus.homework.homework16.test.unit.fakes;

import ru.otus.homework.homework16.app.game.GameWinnerPrinter;
import ru.otus.homework.homework16.app.game.Player;
import ru.otus.homework.homework16.assertions.Assertions;

public class GameWinnerConsolePrinterFake01 implements GameWinnerPrinter {
    @Override
    public void printWinner(Player winner) {
        System.out.printf(winner.getName());
    }
}
