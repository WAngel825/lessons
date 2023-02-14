package ru.otus.homework.homework12;

import java.util.*;

class Account {
    private int accountNumber;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientName, client.clientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName);
    }
}




public class HomeWork12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInputClient = 1;
        int nextInputAccount = 1;
        int nextInputAccountInt = 1;

        Map <Account, Client> clientAccounts = new HashMap<Account, Client>();
    //    clientAccounts.put(new Account(1234), new Client("ivanov"));
    //    clientAccounts.put(new Account(1235), new Client("ivanov"));
    //    clientAccounts.put(new Account(1236), new Client("ivanov"));
    //    clientAccounts.put(new Account(1111), new Client("petrov"));
    //    clientAccounts.put(new Account(2222), new Client("petrov"));
    //    clientAccounts.put(new Account(3333), new Client("gurnov"));
    //    clientAccounts.put(new Account(4444), new Client("gurnov"));
    //    clientAccounts.put(new Account(5555), new Client("gurnov"));



        do {
            System.out.println("Введите фамилию клиента: ");
            String surname = scanner.nextLine();

            do {
                System.out.println("Введите номер счета клиента: ");
                int accountInInt = checkAccount();

                clientAccounts.put(new Account(accountInInt), new Client(surname));

                System.out.println("Хотите еще ввести номер счета клиента? 1/0");

                nextInputAccount = Integer.valueOf(scanner.nextLine());

            } while (nextInputAccount == 1);

            System.out.println("Хотите ввести другого клиента? 1/0");
            nextInputClient = Integer.valueOf(scanner.nextLine());

        } while (nextInputClient == 1);

        System.out.println();
        System.out.println("Введите номер счета для поиска: ");

        int accountToFind = checkAccount();

        if (clientAccounts.containsKey(new Account(accountToFind))) {
            System.out.println(clientAccounts.get(new Account(accountToFind)).getClientName());
        } else {
            System.out.println("такой счет не найден");
        }

        System.out.println();
        System.out.println("Введите фамилию клиента для поиска: ");

        String surnameToFind = scanner.nextLine();

        if (clientAccounts.containsValue(new Client(surnameToFind))) {
            for(Map.Entry<Account, Client> item : clientAccounts.entrySet()){
                if (item.getValue().getClientName().equals(surnameToFind)) {
                    System.out.println(item.getKey().getAccountNumber());
                }
            }
        } else {
            System.out.println("такой клиент не найден");
        }


    }

    private static int checkAccount() {
        int check = 0;
        int accountInInt = 0;
        Scanner scannerIn = new Scanner(System.in);
        while (check == 0) {
            String accountInStr = scannerIn.nextLine();
            accountInInt = 0;

            try {
                accountInInt = Integer.valueOf(accountInStr);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели строку, а не число. Номер счета может состоять только из цифр от 0 до 9");
            }
            if (accountInInt > 0) {
                check++;
            } else {
                System.out.println("Введите номер счета еще раз: ");
            }
        }
        return accountInInt;
    }
}