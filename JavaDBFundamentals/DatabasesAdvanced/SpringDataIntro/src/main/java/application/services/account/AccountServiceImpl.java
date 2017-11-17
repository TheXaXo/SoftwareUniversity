package application.services.account;

import application.models.Account;
import application.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        if (!this.accountRepository.exists(id)) {
            throw new IllegalArgumentException("Account does not exist.");
        }

        Account account = this.accountRepository.findOne(id);

        if (account.getUser() == null) {
            throw new IllegalArgumentException("Account does not have user.");
        }

        if (account.getBalance().compareTo(money) > 0) {
            throw new IllegalArgumentException("Account has insufficient balance.");
        }

        account.setBalance(account.getBalance().subtract(money));
        this.accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        if (!this.accountRepository.exists(id)) {
            throw new IllegalArgumentException("Account does not exist.");
        }

        Account account = this.accountRepository.findOne(id);

        if (account.getUser() == null) {
            throw new IllegalArgumentException("Account does not have user.");
        }

        if (money.compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalArgumentException("Transfer value is negative.");
        }

        account.setBalance(account.getBalance().add(money));
        this.accountRepository.save(account);
    }
}