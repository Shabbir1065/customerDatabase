package com.example.customerDatabase.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            new Customer(
                    1L,
                    "Shabbir",
                    "shabbir1065@gmail.com",
                    "4162223333",
                    LocalDate.of(2003, Month.OCTOBER,25),
                    "1234 Derry rd"
            );
        };
    }
}
