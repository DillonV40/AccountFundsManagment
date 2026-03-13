package djv.account.management.service;

import djv.account.management.enums.AccountTypes;
import djv.account.management.model.Account;
import djv.account.management.model.Member;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public int createAccount(Account account) {
        return account.getAccountNumber();
    }

}
