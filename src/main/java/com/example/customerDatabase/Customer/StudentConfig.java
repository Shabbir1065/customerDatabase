package com.example.customerDatabase.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args -> {
            Customer shabbir = new Customer(
                    "Shabbir",
                    "shabbir1065@gmail.com",
                    "4162223333",
                    LocalDate.of(2003, Month.OCTOBER,25),
                    "1234 Derry rd"
            );

            Customer jonathan = new Customer(
                    "Jonathan",
                    "jono.lasang@gmail.com",
                    "4161115555",
                    LocalDate.of(2003, Month.AUGUST,17),
                    "5678 Trafalgar rd"
            );

            Customer taqi = new Customer(
                    "Taqi",
                    "taqi313@gmail.com",
                    "6471213434",
                    LocalDate.of(2003, Month.OCTOBER,19),
                    "123 Ruhl rd"
            );

            repository.saveAll(
                    List.of(shabbir, jonathan, taqi)
            );
        };
    }
}
