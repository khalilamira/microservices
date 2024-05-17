package tn.amira.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.amira.accountservice.entities.BankAccount;
import tn.amira.accountservice.repository.BankAccountRepository;

import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository){
        return args -> {
            BankAccount bankAccount = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .build();

        };
    }

}
