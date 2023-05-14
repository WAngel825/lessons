package ru.otus.homework.homework16.test.unit.fakes;

import ru.otus.homework.homework16.app.game.Dice;


public class DiceImplFake02 implements Dice {
    private boolean isFirstCall = true;
    @Override
    public int roll() {
        int result = (isFirstCall ? 1 : 2);

        if (isFirstCall) isFirstCall = false;

        return result;
    }
}
