package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Account {
    public final static List<Account> ACCOUNTS = new ArrayList<>();
    private Long accountNumber;
    private String agencyNumber;
    private Double balance;

    public Account(Long accountNumber, String agencyNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.balance = balance;
        ACCOUNTS.add(this);
    }

    public static List<Account> getAccounts() {
        return ACCOUNTS;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void withdraw(Double amount) {
        setBalance(getBalance() - amount);
    }

    public void transfer(Double amount, Long destinationNumberAccount) {
        Optional<Account> accountDestinationsOpt = ACCOUNTS.stream()
                .filter(account -> account.getAccountNumber().equals(destinationNumberAccount))
                .findFirst();

        if (accountDestinationsOpt.isPresent()) {
            Account account = accountDestinationsOpt.get();
            if(getBalance() >= amount) {
                account.setBalance(getBalance() + amount);
                setBalance(getBalance() - amount);
                System.out.println("Transfer of U$" + amount + " successfully made to account: " + account.getAccountNumber());
            } else {
                System.out.println("Insufficient funds in account to transfer U$" + amount + ". Actually balance: U$" + balance);
            }
        } else {
            throw new RuntimeException("No account found for destination number " + destinationNumberAccount);
        }
    }

    @Override
    public String toString() {
        return "\nAccount Number: " + accountNumber +
                "\nAgency Number: " + agencyNumber +
                "\nBalance: U$" + balance;
    }
}
