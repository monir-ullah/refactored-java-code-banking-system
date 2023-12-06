// UserInfo.java

import java.util.ArrayList;
import java.util.Scanner;

public class UserInfo {
    private static final int INITIAL_DEPOSIT = 100;

    private ArrayList<Integer> amount = new ArrayList<>();
    private Scanner scanner;
    private String name;

    public UserInfo(String name, Scanner scanner) {
        this.name = name;
        this.scanner = scanner;
        initializeAccount();
    }

    private void initializeAccount() {
        amount.add(INITIAL_DEPOSIT);
    }

    public void menu() {
        while (true) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    viewBalance();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void printMenu() {
        System.out.print("Press 1 for Deposit\nPress 2 for View Balance\nPress 3 for Withdraw\nPress 4 to Exit: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        int depositAmount = scanner.nextInt();
        amount.set(0, amount.get(0) + depositAmount);
        System.out.println("Amount added: " + depositAmount);
        displayBalance();
    }

    private void viewBalance() {
        displayBalance();
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        int withdrawAmount = scanner.nextInt();
        if (hasSufficientFunds(withdrawAmount)) {
            amount.set(0, amount.get(0) - withdrawAmount);
            System.out.println("Withdrawn Amount: " + withdrawAmount);
        } else {
            System.out.println("Insufficient funds");
        }
        displayBalance();
    }

    private boolean hasSufficientFunds(int withdrawAmount) {
        return amount.get(0) >= (withdrawAmount + INITIAL_DEPOSIT);
    }

    private void displayBalance() {
        System.out.println("Your Balance Is: " + amount.get(0));
        System.out.println("Press any key and enter");
        scanner.next();
    }
}
