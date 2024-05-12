package service;

import interfaces.AccountServiceInterface;
import model.Account;

import java.util.List;

import static model.Account.ACCOUNTS;

public class AccountService implements AccountServiceInterface {
    @Override
    public void createAccount(Account account) {
        ACCOUNTS.add(account);
    }

    @Override
    public List<Account> getAccounts() {
        return ACCOUNTS;
    }

    @Override
    public Account getAccount(Long accountNumber) {
        return ACCOUNTS.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst().orElseThrow();
    }
}
