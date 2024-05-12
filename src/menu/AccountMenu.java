package menu;

import model.Customer;

import java.util.Scanner;

import static menu.CustomerMenu.customerMenu;
import static menu.TransactionsMenu.transactionMenu;

public class AccountMenu {
    private static final Scanner sc = new Scanner(System.in);

    public static void accMenu(Customer customer) {
        while (true) {
            System.out.println("****** Account Menu ******");
            System.out.println("1. See My Account\n2. See My Balance\n3. Transactions\n4. Exit");
            var option = sc.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("****** See My Account ******");
                    System.out.println(customer.getAccount());
                    break;
                }
                case 2: {
                    System.out.println("****** See My Balance ******");
                    System.out.println(customer.getAccount().getBalance());
                    break;
                }
                case 3: {
                    transactionMenu(customer);
                }
                case 4: {
                    System.out.println("Returning to main menu...");
                    customerMenu(customer);
                }
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
