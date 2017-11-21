package application;

import application.models.Account;
import application.models.User;
import application.services.account.AccountServiceImpl;
import application.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserServiceImpl userService;
    private AccountServiceImpl accountService;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService, AccountServiceImpl accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = new User("Pesho", 12);
        Account account = new Account(new BigDecimal("100"), user);
        user.setAccounts(new HashSet<Account>());
        user.getAccounts().add(account);

        System.out.println(user.getAccounts());

        this.userService.registerUser(user);
    }
}