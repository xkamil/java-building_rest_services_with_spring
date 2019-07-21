package com.canx.restapp.sheduled;

import com.canx.restapp.model.Employee;
import com.canx.restapp.repository.EmployeeRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledEmployeeCreator {

    private static final Logger log = LoggerFactory.getLogger(ScheduledEmployeeCreator.class);

    private final EmployeeRepository employeeRepository;

    public ScheduledEmployeeCreator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Scheduled(fixedRate = 500000)
    public void createEmployee() {
        Employee employee = new Employee(RandomStringUtils.randomAlphabetic(5),
                RandomStringUtils.randomAlphabetic(5), "qa");

        Employee employee1 = employeeRepository.save(employee);
        log.info("Created employee {}", employee1);
    }
}
