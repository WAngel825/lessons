package ru.otus.homework.homework27.app;

public class CheckMoney {
    public static String CheckMoney(String moneyStr) {
        int moneyInt = 0;
        String result = "";

        try {
            moneyInt = Integer.parseInt(moneyStr);
        } catch (NumberFormatException e) {
            result = "Введеное значение не является целым числом";
        }

        if (moneyInt > 999999) {result = "Введенное число больше 999 999";}
        if (moneyInt < 0)  {result = "Введенное число меньше нуля. Деньги не могут быть отрицательным числом";}

        return result;
    }
}
