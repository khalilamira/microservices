package tn.amira.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.amira.accountservice.dtos.AccountType;
import tn.amira.accountservice.models.Customer;

import java.time.LocalDate;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private long customerId;
}
