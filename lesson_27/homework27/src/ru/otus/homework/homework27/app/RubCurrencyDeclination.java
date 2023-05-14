package ru.otus.homework.homework27.app;

public class RubCurrencyDeclination implements CurrencyDeclination {
    private static final String[] currency = {"рубль", "рубля", "рублей"};
    @Override
    public String getCurrencyDeclination(int money) {
        int rest = money % 10;
        String result = switch (rest) {
            case 0 -> currency[2];
            case 1 -> currency[0];
            case 2, 3, 4 -> currency[1];
            case 5, 6, 7, 8, 9 -> currency[2];
            default -> " ";
        };
        return result;
    }
}
