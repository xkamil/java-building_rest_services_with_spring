package com.canx.restapp.repository.exception;

public class EmployeeNotFoundException extends EntityNotFoundException {

    public EmployeeNotFoundException(Long id) {
        super(String.format("Employee with id %d not found.", id));
    }
}
