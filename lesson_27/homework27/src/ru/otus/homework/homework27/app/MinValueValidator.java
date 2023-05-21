package ru.otus.homework.homework27.app;

public class MinValueValidator implements Validator{
    @Override
    public String check(String posibleMoney) {
        int moneyInt = 0;
        String result = "";

        try {
            moneyInt = Integer.parseInt(posibleMoney);
            if (moneyInt < 0)  {result = "Введенное число меньше нуля. Деньги не могут быть отрицательным числом";}
        } catch (NumberFormatException e) {
            result = "Введеное значение не является целым числом";
        }
        return result;
    }
}
