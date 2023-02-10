package ru.otus.homework.homework06freearray;

import java.util.Scanner;

public class HomeWork06FreeArray {
    public static void main(String[] args) {

        int answerToInt = 0;

        String[] freeArray;

        String[] freeArrayBase = {"test"};

        freeArray = new String[freeArrayBase.length + 1];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Хотите добавить элемент в массив?");
        System.out.println("1. Да");
        System.out.println("2. Нет");

        int checkAnswer = 0;

        while (checkAnswer == 0) {
            System.out.print("Ваш ответ: ");
            String answer = scanner.nextLine();

            try {
                answerToInt = Integer.valueOf(answer);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели строку, а не число. Пожалуйста, введите номер ответа");
            }

            if (answerToInt > 0) {
                if (answerToInt > 2) {
                    System.out.println("Такого варианта ответа нет. Пожалуйста, введите корректный номер ответа");
                } else {
                    checkAnswer = 1;
                    System.out.println("Введите следующий элемент массива");
                    String nextElement = scanner.nextLine();


                    System.arraycopy(freeArrayBase, 0, freeArray, 0, freeArrayBase.length);
                    freeArray[freeArrayBase.length] = nextElement;

                    }
                }

            }


        System.out.println("Массив состоит из:");

        for (String s : freeArray) {
            System.out.println(s);
        }


    }
}