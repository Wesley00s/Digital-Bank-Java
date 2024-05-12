package menu;

import enummeration.TypeUser;
import model.Address;
import model.Customer;
import model.Manager;

import java.util.Scanner;

import static menu.ManagerMenu.managerMenu;
import static model.Customer.CUSTOMERS;


public class ManagerLogin {
    private final static Scanner sc = new Scanner(System.in);

    public static void createMainAdm() {
        new Manager("Wesley", "12345", 26, new Address("Street 1", "City 1", "State 1", "zip 1"));
    }

    public static void managerLogin() {

        System.out.println("****** Manager Login ******");
        System.out.println("Enter your username:");
        var username = sc.nextLine();
        System.out.println("Enter your password:");
        var password = sc.next();

        for (Customer c : CUSTOMERS) {
            if (c.getName().equals(username) && c.getPassword().equals(password) && c.getTypeUser().equals(TypeUser.MANAGER)) {
                System.out.println("Manager logged in");
                managerMenu();
                return;
            }
        }
        System.out.println("Username or password doesn't match");
    }
}
