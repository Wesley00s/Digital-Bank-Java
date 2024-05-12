package menu;

import enummeration.TypeUser;
import model.Customer;

import java.util.Scanner;

import static menu.CustomerMenu.customerMenu;
import static model.Customer.CUSTOMERS;

public class CustomerLogin {
    private final static Scanner sc = new Scanner(System.in);

    public static void customerLogin() {
        System.out.println("****** Customer Login ******");
        System.out.println("Enter your username:");
        var username = sc.nextLine();
        System.out.println("Enter your password:");
        var password = sc.nextLine();

        for(Customer c : CUSTOMERS) {
            if(c.getName().equals(username) && c.getPassword().equals(password) && c.getTypeUser().equals(TypeUser.CUSTOMER)) {
                System.out.println("Customer logged in");
                customerMenu(c);
                return;
            }
        }
        System.out.println("Username or password doesn't match");
    }
}
