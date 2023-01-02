package com.rbfernando99.Ponos.Employee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> one(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee newEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public Optional<Employee> replaceEmployee(Employee newEmployee, Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setRole(newEmployee.getRole());
                    return employeeRepository.save(employee);
                });
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Employee> all() {
        return employeeRepository.findAll();
    }

}
