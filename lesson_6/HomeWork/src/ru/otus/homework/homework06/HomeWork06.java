package ru.otus.homework.homework06;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork06 {
    public static void main(String[] args) {

        int correctCount = 0;

        int incorrectCount = 0;

        String[] questions = {"Какой народ, кивая утвердительно, имеет в виду «нет» и наоборот?",
                              "Какое из списка этих древних имен относится к мужским?",
                              "Какая приправа производится из сушеной коры вечнозеленых деревьев?"};

        String[][] answers = {{"Китайцы", "Болгары", "Финны", "Казахи"},
                              {"Лиа", "Иохаведа", "Рахиль", "Иона"},
                              {"Шафран", "Гвоздика", "Корица", "Горчица"}};

        int[] rightAnswers = {2, 4, 3};

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            int countAnswersInQuestion = answers[i].length; //Arrays.toString(answers[i]).length();

            for (int j = 0; j < countAnswersInQuestion; j++) {
                System.out.println((j + 1) + ". " + answers[i][j]);
            }

            int checkAnswer = 0;

            while (checkAnswer == 0) {
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
                        if (posibleAnswerToInt == rightAnswers[i]) {
                            correctCount++;
                        } else {
                            incorrectCount++;
                        }

                    }
                }

            }

        }

        System.out.println("Результат: правильно " + correctCount + ", неправильно " + incorrectCount);

    }
}