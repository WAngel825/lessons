package ru.otus.homework.homework16.test.unit.fakes;

import ru.otus.homework.homework16.app.game.GameWinnerPrinter;
import ru.otus.homework.homework16.app.game.Player;

public class GameWinnerConsolePrinterFake02 implements GameWinnerPrinter {
    Player mainPlayer;
    @Override
    public void printWinner(Player winner) {
        System.out.printf(winner.getName());
        mainPlayer = winner;
    }

    public Player getMainPlayer() {
        return mainPlayer;
    }
}
