package tn.amira.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import tn.amira.customerservice.config.GlobalConfig;
import tn.amira.customerservice.entities.Customer;
import tn.amira.customerservice.repository.CustomerRepository;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.firstName("JAD")
					 		.lastName("AMIRA")
							.email("JAD@gmail.com").build(),
					Customer.builder()
							.firstName("MARYEM")
							.lastName("AMIRA")
							.email("JAD@gmail.com").build()
			);
			customerRepository.saveAll(customerList);
		};
	}

}
