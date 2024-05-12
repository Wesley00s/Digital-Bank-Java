package menu;

import enummeration.TypeUser;
import model.Address;
import model.Customer;

import java.util.Scanner;

import static menu.MainMenu.mainMenu;
import static model.Customer.CUSTOMERS;

public class ManagerMenu {
    private final static Scanner sc = new Scanner(System.in);

    public static void managerMenu() {
        while (true) {
            System.out.println("******* Manager Menu *******");
            System.out.println("1. Add Customer\n2. Show Customers\n3. Remove Customer\n4. Return");
            var option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    System.out.println("****** Add Customer ******");
                    System.out.println("Enter customer name: ");
                    var name = sc.nextLine();
                    System.out.println("Enter customer password:");
                    var password = sc.nextLine();
                    System.out.println("Enter customer age:");
                    var age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter customer street: ");
                    var street = sc.nextLine();
                    System.out.println("Enter customer city: ");
                    var city = sc.nextLine();
                    System.out.println("Enter customer state: ");
                    var state = sc.nextLine();
                    System.out.println("Enter customer zip code: ");
                    var zip = sc.nextLine();

                    new Customer(name, password, age, new Address(street, city, state, zip));
                    break;
                }
                case 2: {
                    System.out.println("****** Show Customers ******");
                    for(Customer c : CUSTOMERS) {
                        if(c.getTypeUser().equals(TypeUser.CUSTOMER)) {
                            System.out.println(c);
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("****** Remove Customer ******");
                    System.out.println("Enter customer ID to remove: ");
                    var id = sc.nextLong();

                    for(Customer c : CUSTOMERS) {
                        if(c.getId() == id) {
                            CUSTOMERS.remove(c);
                            return;
                        }
                    }
                    System.out.println("Customer not found");
                    break;
                }
                case 4: {
                    System.out.println("Return to main menu...");
                    mainMenu();
                }
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
