package com.kass.integrationtesting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntegrationTestingApplication {

    private static final Logger logger= LoggerFactory.getLogger(IntegrationTestingApplication.class);

    public static void main (String[] args) {
        SpringApplication.run(IntegrationTestingApplication.class, args);
    }

     @Bean
     public CommandLineRunner demo(CustomerRepository customerRepository){
         return (args->{
             customerRepository.save(new Customer("Kassahun"));
             customerRepository.save(new Customer("Getaneh"));
             customerRepository.save(new Customer("Birhanu"));

         });

     }

}
