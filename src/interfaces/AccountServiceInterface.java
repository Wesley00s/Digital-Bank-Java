package interfaces;

import model.Account;

import java.util.ArrayList;
import java.util.List;

public interface AccountServiceInterface {
    void createAccount(Account account);
    List<Account> getAccounts();
    Account getAccount(Long accountNumber);
}
