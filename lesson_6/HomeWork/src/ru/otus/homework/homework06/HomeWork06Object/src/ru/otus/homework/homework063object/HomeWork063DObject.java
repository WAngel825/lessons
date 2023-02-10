package ru.otus.homework.homework063object;

import java.util.Scanner;

public class HomeWork063DObject {
    public static void main(String[] args) {

        int correctCount = 0;

        int incorrectCount = 0;

        Object[][][] quiz = new Object[3][5][2];

        quiz [0][0][0] = "Какой народ, кивая утвердительно, имеет в виду «нет» и наоборот?";
        quiz [0][0][1] = 2;
        quiz [0][1][0] = "Китайцы";
        quiz [0][2][0] = "Болгары";
        quiz [0][3][0] = "Финны";
        quiz [0][4][0] = "Казахи";

        quiz [1][0][0] = "Какое из списка этих древних имен относится к мужским?";
        quiz [1][0][1] = 4;
        quiz [1][1][0] = "Лиа";
        quiz [1][2][0] = "Иохаведа";
        quiz [1][3][0] = "Рахиль";
        quiz [1][4][0] = "Иона";

        quiz [2][0][0] = "Какая приправа производится из сушеной коры вечнозеленых деревьев?";
        quiz [2][0][1] = 3;
        quiz [2][1][0] = "Шафран";
        quiz [2][2][0] = "Гвоздика";
        quiz [2][3][0] = "Корица";
        quiz [2][4][0] = "Горчица";

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < quiz.length; i++) {
            System.out.println(quiz[i][0][0]);

            int countAnswersInQuestion = quiz[i].length - 1;

            for (int j = 1; j <= countAnswersInQuestion; j++) {
                System.out.println((j) + ". " + quiz[i][j][0]);
            }

            int checkAnswer = 0;

            while (checkAnswer == 0) {
                System.out.print("Ваш ответ: ");
                String possibleAnswer = scanner.nextLine();
                int posibleAnswerToInt = 0;

                try {
                    posibleAnswerToInt = Integer.valueOf(possibleAnswer);
                } catch (NumberFormatException e) {
                    System.out.println("Вы ввели строку, а не число. Пожалуйста, введите номер ответа");
                }

                if (posibleAnswerToInt > 0) {

                    if (posibleAnswerToInt > countAnswersInQuestion) {
                        System.out.println("Такого варианта ответа нет. Пожалуйста, введите корректный номер ответа");

                    } else {

                        checkAnswer++;
                        if (posibleAnswerToInt == (int) quiz[i][0][1]) {
                            correctCount++;
                            System.out.println("Правильно!");
                        } else {
                            incorrectCount++;
                            System.out.println("Неправильно...");
                        }

                    }
                }

            }
            System.out.println();
        }

        System.out.println("Результат: правильно " + correctCount + ", неправильно " + incorrectCount);

    }
}