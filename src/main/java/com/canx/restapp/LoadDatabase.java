package com.canx.restapp;

import com.canx.restapp.model.Employee;
import com.canx.restapp.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Kamil", "Wrobel", "qa")));
            log.info("Preloading " + repository.save(new Employee("Tomek", "Wrobel", "lead")));
        };
    }
}
