package ru.otus.homework.homework16.test.unit.fakes;

import ru.otus.homework.homework16.app.game.Dice;


public class DiceImplFake01 implements Dice {
    @Override
    public int roll() {
        return 5;
    }
}
