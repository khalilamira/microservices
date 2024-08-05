package tn.amira.customerservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.amira.customerservice.entities.Customer;
import tn.amira.customerservice.repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
    @GetMapping("/customer/{id}")
    public Customer customerById(Long id){
        return customerRepository.findById(id).get();
    }
}
