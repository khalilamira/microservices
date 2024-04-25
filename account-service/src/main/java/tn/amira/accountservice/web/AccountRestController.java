package tn.amira.accountservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.amira.accountservice.entities.BankAccount;
import tn.amira.accountservice.repository.BankAccountRepository;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository accountRepository;

    public AccountRestController(BankAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        return accountRepository.findAll();
    }


}
