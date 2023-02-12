package ru.otus.homework.homework06freearray;

import java.util.Scanner;

public class HomeWork06FreeArray {
    public static void main(String[] args) {

        String[] freeArray;

        String[] freeArrayBase = {"test"};

        freeArray = new String[freeArrayBase.length + 1];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите следующий элемент массива");
        String nextElement = scanner.nextLine();

        System.arraycopy(freeArrayBase, 0, freeArray, 0, freeArrayBase.length);
        freeArray[freeArrayBase.length] = nextElement;


        System.out.println("Массив состоит из:");

        for (String s : freeArray) {
            System.out.println(s);
        }


    }
}