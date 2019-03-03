package com.epam.producing.testProject.configuration;

import com.epam.producing.testProject.model.Address;
import com.epam.producing.testProject.model.Employee;
import com.epam.producing.testProject.repository.AddressRepository;
import com.epam.producing.testProject.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        return args -> {
            Employee burglar = new Employee("Bilbo Baggins", "burglar");
            Employee thief = new Employee("Frodo Baggins", "thief");
            log.info("Preloading " + employeeRepository.save(burglar));
            log.info("Preloading " + employeeRepository.save(thief));
            log.info("Preloading " + addressRepository.save(new Address("Kyev", "Vilyamsa", employeeRepository.getOne((long) 1))));
            log.info("Preloading " + addressRepository.save(new Address("Varshava", "Pravdu", employeeRepository.getOne((long) 1))));
            log.info("Preloading " + addressRepository.save(new Address("New York", "5 avenue", employeeRepository.getOne((long) 2))));
        };
    }
}