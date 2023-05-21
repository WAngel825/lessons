package ru.otus.homework.homework27.test;

import ru.otus.homework.homework27.test.unit.*;

public class AllTests {
    public static void main(String[] args) {
        System.out.println("\n\n----------------------\n\n");

        new Test01().test();
        System.out.println("\n\n----------------------\n\n");

        new Test02().test();
        System.out.println("\n\n----------------------\n\n");

        new Test03().test();
        System.out.println("\n\n----------------------\n\n");

        new Test05().test();
        System.out.println("\n\n----------------------\n\n");

        new Test06().test();
        System.out.println("\n\n----------------------\n\n");

        new Test07().test();
        System.out.println("\n\n----------------------\n\n");

        new Test08().test();
        System.out.println("\n\n----------------------\n\n");

        new Test09().test();
        System.out.println("\n\n----------------------\n\n");

        System.out.println("Проверка на числа словами с валютой");
        new Test04().test();
        System.out.println("\n\n----------------------\n\n");

        new Test10().test(25, "двадцать пять рублей");
        new Test10().test(37, "тридцать семь рублей");
        new Test10().test(111, "сто одиннадцать рублей");
        new Test10().test(1111, "одна тысяча сто одиннадцать рублей");
        new Test10().test(378, "триста семьдесят восемь рублей");
        new Test10().test(654132, "шестьсот пятьдесят четыре тысячи сто тридцать два рубля");
        System.out.println("\n----------------------\n");

    }
}
