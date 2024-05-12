package service;

import model.*;

import java.util.List;
import java.util.Scanner;

import static model.Account.ACCOUNTS;


public class Service {
    private static final Scanner sc = new Scanner(System.in);

    private static List<String> infoAcc() {
        System.out.println("Enter account number:");
        String accountNumber = sc.next();
        System.out.println("Enter account agency:");
        String accountAgency = sc.next();
        System.out.println("Enter balance amount:");
        String balanceAmount = sc.next();

        return List.of(accountNumber, accountAgency, balanceAmount);
    }

    public static Account createCustomerAccount() {
        System.out.println("******* Create Customer Account *******");
        System.out.println("What type of account do you want to add to?");
        System.out.println("1 - Current\n2 - Savings");
        String typeAccount = sc.next();

        switch (typeAccount) {
            case "1": {
                System.out.println("******* Create Current Account *******");
                var info = infoAcc();
                return new Current(
                        Long.parseLong(info.getFirst()),
                        info.get(1),
                        Double.parseDouble(info.getLast())
                );
            }
            case "2": {
                System.out.println("******* Create Savings Account *******");
                var info = infoAcc();

                return new Savings(
                        Long.parseLong(info.getFirst()),
                        info.get(1),
                        Double.parseDouble(info.getLast())
                );
            }
            default:
                System.out.println("Invalid option!");
        }

        System.out.println("Account successfully created!");
        return null;
    }

    public static void seeAccount(Customer customer) {
        System.out.println("******* See Account *******");
        var acc = customer.getAccount();
        System.out.println(acc);
    }

    public static void seeBalance(Customer customer) {
        System.out.println("******* See Balance *******");
        var acc = customer.getAccount();
        System.out.println("U$ " + acc.getBalance());
    }

    public static void removeAccount(Customer customer) {
        System.out.println("******* Remove Account *******");
        var acc = customer.getAccount();

        System.out.println("Account:\n " + acc);
        System.out.println("Do you want to remove this account? (y/n)");
        var answer = sc.nextLine();

        switch (answer) {
            case "y": {
                if(acc.getBalance() != 0) {
                    System.out.println("You are out of balance!");
                    return;
                }
                ACCOUNTS.remove(acc);
                System.out.println("Account successfully removed!");
                break;
            }
            case "n": {
                System.out.println("Account not removed!");
                break;
            }
            default:
                System.out.println("Invalid option!");
        }


    }
}

