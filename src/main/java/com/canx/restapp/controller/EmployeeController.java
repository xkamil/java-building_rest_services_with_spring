package com.canx.restapp.controller;

import com.canx.restapp.model.Employee;
import com.canx.restapp.repository.EmployeeRepository;
import com.canx.restapp.repository.exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employees", consumes = "application/json")
public class EmployeeController {

    private final EmployeeRepository repository;


    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    List<Employee> getAllEmployess() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Employee getEmployee(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping()
    Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @PutMapping("/{id}")
    Employee updateEmployee(@RequestBody Employee updatedEmployee, @PathVariable Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setRole(updatedEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
