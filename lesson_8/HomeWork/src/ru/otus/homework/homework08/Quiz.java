package ru.otus.homework.homework08;

import java.util.Scanner;
class Answer {
    private String answerName;

    public Answer(String answerName) {
        this.answerName = answerName;
    }

    public String getAnswerName() {
        return answerName;
    }
}

class AnswersToTheQuestion {
    private String questionName;
    private int countAnswers;
    private Answer[] answers;
    private int rightAnswer;

    public AnswersToTheQuestion (String questionName, int countAnswers) {
        this.questionName = questionName;
        this.countAnswers = countAnswers;
        this.answers = new Answer[countAnswers];
    }

    public String getQuestionName() {
        return questionName;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void addAnswersToTheQuestion(Answer answer, int signOfCorrectAnswer) {
      for (int i = 0; i < this.answers.length; i++) {
          if (answers[i] == null) {
              answers[i] = answer;
              if (signOfCorrectAnswer == 1 ) {
                  rightAnswer = i + 1;
              }
              break;
          }
      }
    }
}

public class Quiz {

  public static void main(String[] args) {
      int correctCount = 0;
      int incorrectCount = 0;
      Scanner scanner = new Scanner(System.in);

      AnswersToTheQuestion[] answersToTheQuestions = new AnswersToTheQuestion[3];

      answersToTheQuestions[0] = new AnswersToTheQuestion("Какой народ, кивая утвердительно, имеет в виду «нет» и наоборот?", 4);
      answersToTheQuestions[0].addAnswersToTheQuestion(new Answer("Китайцы"), 0);
      answersToTheQuestions[0].addAnswersToTheQuestion(new Answer("Болгары"), 1);
      answersToTheQuestions[0].addAnswersToTheQuestion(new Answer("Финны"), 0);
      answersToTheQuestions[0].addAnswersToTheQuestion(new Answer("Казахи"), 0);

      answersToTheQuestions[1] = new AnswersToTheQuestion("Какое из списка этих древних имен относится к мужским?", 4);
      answersToTheQuestions[1].addAnswersToTheQuestion(new Answer("Лиа"), 0);
      answersToTheQuestions[1].addAnswersToTheQuestion(new Answer("Иохаведа"), 0);
      answersToTheQuestions[1].addAnswersToTheQuestion(new Answer("Рахиль"), 0);
      answersToTheQuestions[1].addAnswersToTheQuestion(new Answer("Иона"), 1);

      answersToTheQuestions[2] = new AnswersToTheQuestion("Какая приправа производится из сушеной коры вечнозеленых деревьев?", 4);
      answersToTheQuestions[2].addAnswersToTheQuestion(new Answer("Шафран"), 0);
      answersToTheQuestions[2].addAnswersToTheQuestion(new Answer("Гвоздика"), 0);
      answersToTheQuestions[2].addAnswersToTheQuestion(new Answer("Корица"), 1);
      answersToTheQuestions[2].addAnswersToTheQuestion(new Answer("Горчица"), 0);

      for (int i = 0; i < answersToTheQuestions.length; i++) {
          System.out.println(answersToTheQuestions[i].getQuestionName());
          Answer[] possibleAnswer = answersToTheQuestions[i].getAnswers();
          int countAnswersInQuestion = possibleAnswer.length;
          for (int j = 0; j < possibleAnswer.length; j++) {
              System.out.println((j + 1) + ". " + possibleAnswer[j].getAnswerName());
          }

          int checkAnswer = 0;

          while (checkAnswer == 0) {
              System.out.print("Ваш ответ: ");
              String possibleAnswerString = scanner.nextLine();
              int posibleAnswerToInt = 0;

              try {
                  posibleAnswerToInt = Integer.valueOf(possibleAnswerString);
              } catch (NumberFormatException e) {
                  System.out.println("Вы ввели строку, а не число. Пожалуйста, введите номер ответа");
              }

              if (posibleAnswerToInt > 0) {
                  if (posibleAnswerToInt > countAnswersInQuestion) {
                      System.out.println("Такого варианта ответа нет. Пожалуйста, введите корректный номер ответа");

                  } else {

                      checkAnswer++;
                      if (posibleAnswerToInt == answersToTheQuestions[i].getRightAnswer()) {
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