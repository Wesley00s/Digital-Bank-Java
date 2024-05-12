package menu;

import java.util.Scanner;

import static menu.CustomerLogin.customerLogin;
import static menu.ManagerLogin.managerLogin;

public class MainMenu {
    private final static Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("****** Menu ******");
        System.out.println("What type user you are?");
        System.out.println("1. Customer\n2. Manager");
        var option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1: {
               customerLogin();
               break;
            }
            case 2: {
                managerLogin();
                break;
            }
            default:
                System.out.println("Invalid option");
        }
    }
}
