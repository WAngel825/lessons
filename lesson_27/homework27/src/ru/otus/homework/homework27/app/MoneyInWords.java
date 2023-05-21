package ru.otus.homework.homework27.app;

public class MoneyInWords {
    private final CurrencyDeclination currencyDeclination;
    private static final String[][] units = {{"один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
                                             {"одна", "две"}};
    private static final String[] dozens = {"двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String[] hundreds = {"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static final String[] tenths  = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
                                             "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] levelDigit = {"тысяча", "тысячи", "тысяч"};

    public MoneyInWords(CurrencyDeclination currencyDeclination) {
        this.currencyDeclination = currencyDeclination;
    }

    private static String getRank(int number, int level) {
        String result;
        if (level == 0) {
            result = "";
        } else {
            result = switch (number % 10) {
                case 0 -> levelDigit[2];
                case 1 -> levelDigit[0];
                case 2, 3, 4 -> levelDigit[1];
                case 5, 6, 7, 8, 9 -> levelDigit[2];
                default -> "";
            };
        }

        return result;
    }

    private static String getDigitToString(int digit, int level) {
        String words = "";

        if (digit == 0) {
            words = "ноль";
        }

        int unit = digit % 10;
        int dozen = (digit / 10) % 10;
        int hundred = (digit / 100) % 10;

        if (hundred > 0) {
            words = hundreds[hundred - 1];
        }

        if (dozen == 1) {
            words = words + " " + tenths[unit];
        }

        if (dozen > 1) {
            words = words + " " + dozens[dozen - 2];
        }

        if ((unit > 0) && (dozen != 1)) {
            words = words + " " + units[(unit == 1 || unit == 2) ? level : 0][unit - 1];
        }

        words = words + " " + getRank(digit, level);


        return words.trim();
    }

    public String getMoneyInWords(int money) {
        int digitLevel = -1;
        int unit = money;
        int digit = money;
        int i = 0;
        String result = "";

        do {
            unit = unit / 1000;
            digitLevel++;
        } while (unit > 0);

        do {
            if ((digitLevel == 0) || (digit % 1000 > 0)) {
                result = getDigitToString(digit % 1000, i) + " " + result;
            }
            digit = (int) (digit / (1000 * Math.pow(10, i)));
            i++;
        } while (i <= digitLevel);

        result = result.trim() + " " + currencyDeclination.getCurrencyDeclination(money);

        return result.trim();
    }

}
