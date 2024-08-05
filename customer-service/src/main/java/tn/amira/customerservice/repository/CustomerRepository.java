package tn.amira.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.amira.customerservice.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
