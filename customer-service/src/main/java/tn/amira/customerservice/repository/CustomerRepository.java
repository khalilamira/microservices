package tn.amira.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.amira.customerservice.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
