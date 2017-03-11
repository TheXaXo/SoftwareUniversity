package BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        String command = reader.readLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Create":
                    int id = Integer.parseInt(tokens[1]);

                    if (bankAccounts.containsKey(id)) {
                        System.out.println("Account already exists");
                    } else {
                        BankAccount account = new BankAccount();
                        account.setId(id);

                        bankAccounts.put(id, account);
                    }
                    break;

                case "Deposit":
                    id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);

                    if (!isValidId(bankAccounts, id)) {
                        System.out.println("Account does not exist");
                        break;
                    }

                    bankAccounts.get(id).deposit(amount);
                    break;

                case "Withdraw":
                    id = Integer.parseInt(tokens[1]);
                    amount = Double.parseDouble(tokens[2]);

                    if (!isValidId(bankAccounts, id)) {
                        System.out.println("Account does not exist");
                        break;
                    }

                    try {
                        bankAccounts.get(id).withdraw(amount);
                    } catch (IllegalStateException ex) {
                        System.out.println("Insufficient balance");
                    }
                    break;

                case "Print":
                    id = Integer.parseInt(tokens[1]);

                    if (!isValidId(bankAccounts, id)) {
                        System.out.println("Account does not exist");
                        break;
                    }

                    System.out.printf("Account ID%d, balance %.2f%n", id, bankAccounts.get(id).getBalance());
                    break;
            }

            command = reader.readLine();
        }
    }

    public static boolean isValidId(HashMap<Integer, BankAccount> accounts, int id) {
        return accounts.containsKey(id);
    }
}