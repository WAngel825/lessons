package ru.otus.homework.homework16.test;

import ru.otus.homework.homework16.test.unit.*;

public class AllTests {
    public static void main(String[] args) {
        System.out.println("\n\n----------------------\n\n");

        new DiceImplTest01().testDiceImplN01();
        System.out.println("\n\n----------------------\n\n");

        new DiceImplTest02().testDiceImplN02();
        System.out.println("\n\n----------------------\n\n");

        new DiceImplTest03().testDiceImplN03();
        System.out.println("\n\n----------------------\n\n");

        new DiceImplTest04().testDiceImplN04();
        System.out.println("\n\n----------------------\n\n");

    }
}
