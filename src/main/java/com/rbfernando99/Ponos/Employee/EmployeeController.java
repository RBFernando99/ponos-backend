package com.rbfernando99.Ponos.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public Optional<Employee> one(@PathVariable Long id) {
        return employeeService.one(id);
    }

    @PostMapping
    public Employee newEmployee(@RequestBody Employee employee) {
        return employeeService.newEmployee(employee);
    }

    @PutMapping("/{id}")
    public Optional<Employee> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employeeService.replaceEmployee(newEmployee, id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping
    public List<Employee> all() {
        return employeeService.all();
    }

}
