package menu;


import model.Customer;

import java.util.Scanner;

import static service.Service.*;

public class CustomerMenu {
    private static final Scanner sc = new Scanner(System.in);

    public static void customerMenu(Customer customer) {
        while (true) {
            System.out.println("******* Customer Menu *******");
            System.out.println("1. Create Account\n2. Access My Account\n3. Exit");
            var option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    var acc = createCustomerAccount();
                    customer.setAccount(acc);
                    break;
                }
                case 2: {
                    if (customer.getAccount() == null) {
                        System.out.println("You not have any account");
                        return;
                    }
                    seeAccount(customer);
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
