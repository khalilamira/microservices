package tn.amira.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tn.amira.accountservice.clients.CustomerRestClient;
import tn.amira.accountservice.dtos.AccountType;
import tn.amira.accountservice.entities.BankAccount;
import tn.amira.accountservice.repository.BankAccountRepository;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository,CustomerRestClient customerRestClient){
        return args -> {
            customerRestClient.allCustomers().forEach(c->{
                BankAccount bankAccount = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*8000)
                        .createdAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(c.getId())
                        .build();
                BankAccount bankAccount2 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*67399)
                        .createdAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(c.getId())
                        .build();
                accountRepository.save(bankAccount);
                accountRepository.save(bankAccount2);
            });
        };
    }

}
