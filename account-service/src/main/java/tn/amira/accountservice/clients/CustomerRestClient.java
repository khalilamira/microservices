package tn.amira.accountservice.clients;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.amira.accountservice.models.Customer;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable long id);
    @GetMapping("/api/customers")
    @CircuitBreaker(name="customerService" , fallbackMethod = "getAllCustomers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(long id, Exception exception){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("not available");
        customer.setLastName("not available");
        customer.setEmail("not available");
        return customer;

    }

    default List<Customer> getAllCustomers(Exception exception){
        return List.of();
    }

}
