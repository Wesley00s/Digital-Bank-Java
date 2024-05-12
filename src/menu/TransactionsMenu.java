package menu;

import model.Customer;

import java.util.Scanner;

import static menu.AccountMenu.accMenu;

public class TransactionsMenu {
    private static final Scanner sc = new Scanner(System.in);

    public static void transactionMenu(Customer customer) {
        while (true) {
            System.out.println("****** Transaction Menu ******");
            System.out.println("1. Deposit\n2. Withdraw\n3. Transfer\n4. Exit");
            var option = sc.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("Enter amount to deposit: ");
                    var amount = sc.nextDouble();
                    if (amount > 0) {
                        customer.getAccount().deposit(amount);
                    } else {
                        System.out.println("Enter valid amount to deposit");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter amount to withdraw: ");
                    var amount = sc.nextDouble();
                    if (amount > 0) {
                        customer.getAccount().withdraw(amount);
                    } else {
                        System.out.println("Enter valid amount to withdraw");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter amount to transfer: ");
                    var amount = sc.nextDouble();
                    System.out.println("Enter destination account number: ");
                    var destinationAccountNumber = sc.nextLong();
                    if (amount > 0) {
                        customer.getAccount().transfer(amount, destinationAccountNumber);
                    } else {
                        System.out.println("Enter valid amount to transfer");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Returning to main menu...");
                    accMenu(customer);
                }
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
