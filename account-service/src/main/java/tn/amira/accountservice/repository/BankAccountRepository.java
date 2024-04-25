package tn.amira.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.amira.accountservice.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
