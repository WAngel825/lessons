package ru.otus.homework.homework27.app;

public class MaxValueValidator  implements Validator {
    @Override
    public String check(String posibleMoney) {
        int moneyInt = 0;
        String result = "";

        try {
            moneyInt = Integer.parseInt(posibleMoney);
            if (moneyInt > 999999) {result = "Введенное число больше 999 999";}
        } catch (NumberFormatException e) {
            result = "Введеное значение не является целым числом";
        }
        return result;
    }
}
