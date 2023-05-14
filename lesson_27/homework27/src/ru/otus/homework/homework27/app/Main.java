package ru.otus.homework.homework27.app;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final String INTRODUCTION = "Пожалуйста, введите целое положительное число до 999 999 без пробелов и других символов";

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println(INTRODUCTION);
    String possibleMoneyStr = scanner.nextLine();

    String errors = CheckMoney.CheckMoney(possibleMoneyStr);

    if (!Objects.equals(errors, "")) {
      System.out.println(errors);
    }
    else {
      int possibleMoneyInt = 0;

      try {
        possibleMoneyInt = Integer.parseInt(possibleMoneyStr);
      } catch (NumberFormatException e) {
        System.out.println("Вы ввели строку, а не число");
      }

      CurrencyDeclination currencyDeclination = new RubCurrencyDeclination();
      MoneyInWords moneyInWords = new MoneyInWords(currencyDeclination);

      String resultWord = moneyInWords.getMoneyInWords(possibleMoneyInt);

      System.out.println(resultWord);
    }
  }



}
