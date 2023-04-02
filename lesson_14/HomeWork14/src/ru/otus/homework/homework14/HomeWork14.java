package ru.otus.homework.homework14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Account {
    private int accountNumber;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

}
class Client {

    private String clientName;

    public Client(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }
}

class ClientAccounts {
    private List <Account> accountList;

    public ClientAccounts (Client client) {
        this.accountList = new ArrayList<Account>();
    }

    public void setAccountForClient(Account account) {
        this.accountList.add(account);
    }
}
public class HomeWork14 {
    static final int MAX_CHANCE = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String clientName;
        Account clientAccount;

        System.out.println("Введите имя первого клиента");
        clientName = scanner.nextLine();
        ClientAccounts firstClient = new ClientAccounts(new Client(clientName));

        System.out.println("У клиента 2 счета");
        for (int i = 0; i < 2; i++) {
            System.out.println("Введите номер " + (i + 1) + "-ого счета");
            try{
                clientAccount = new Account(checkAccount());
                firstClient.setAccountForClient(clientAccount);
            } catch (Exception e) {
                System.out.println(e);
                System.exit(53);
            }
        }

        System.out.println("Введите имя второго клиента");
        clientName = scanner.nextLine();
        ClientAccounts secondClient = new ClientAccounts(new Client(clientName));

        System.out.println("Загрузка счетов клиента из файла...");

        int successLodedAccount = 0;
        int unluckyLoadAccount = 0;
        try {
            FileReader fileReader = new FileReader("F:\\test.txt");
            try (BufferedReader reader = new BufferedReader(fileReader)) {
                List <String> accountsListFromFile;
                String text = reader.readLine();
                accountsListFromFile = Arrays.asList(text.split("\\s*,\\s*"));
                for(int k = 0; k < accountsListFromFile.size(); k++) {
                    try {
                        clientAccount = new Account(checkAccount(accountsListFromFile.get(k)));
                        secondClient.setAccountForClient(clientAccount);
                        successLodedAccount++;
                    } catch (NumberFormatException e) {
                        unluckyLoadAccount++;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            System.exit(53);
        }

        if (successLodedAccount == 0 && unluckyLoadAccount == 0) {
            System.out.println("Проблемы с данными файла");
        } else {
            System.out.println("Из файла удачно загружено " + successLodedAccount + " счета/-ов");
        }

    }
    private static int checkAccount() throws Exception {

        int accountInInt = 0;
        Scanner scannerIn = new Scanner(System.in);
        for (int j = 0; j < MAX_CHANCE; j++) {
            String accountInStr = scannerIn.nextLine();
            accountInInt = 0;

            try {
                accountInInt = Integer.valueOf(accountInStr);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели строку, а не число. Номер счета может состоять только из цифр от 0 до 9");
            }
            if (accountInInt > 0) {
                break;
            } else {
                if (j < MAX_CHANCE - 1) {
                    System.out.println("Введите номер счета еще раз: ");
                }
            }
        }
        if (accountInInt > 0) {
            return accountInInt;
        } else {
            throw new Exception("Исчерпаны попытки ввода номера счета ");
        }

    }

    private static int checkAccount(String accountInStr) throws NumberFormatException {
        int accountInInt;
        accountInInt = Integer.valueOf(accountInStr);

        return Math.max(accountInInt, 0);

    }
}

