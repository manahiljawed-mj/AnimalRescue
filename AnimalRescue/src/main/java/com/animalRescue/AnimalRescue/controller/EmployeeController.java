package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.Employee;
import com.animalRescue.AnimalRescue.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping("/read/{id}")
    public Employee readEmployee(@PathVariable Long id) {
        return employeeService.read(id);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Employee> getAllEmployees() {
        return employeeService.getAll();
    }
}
