package ru.otus.homework.homework27.app;

public class IntValidator implements Validator{
    @Override
    public String check(String posibleMoney) {
        int moneyInt = 0;
        String result = "";

        try {
            moneyInt = Integer.parseInt(posibleMoney);
        } catch (NumberFormatException e) {
            result = "Введеное значение не является целым числом";
        }
        return result;
    }

}
