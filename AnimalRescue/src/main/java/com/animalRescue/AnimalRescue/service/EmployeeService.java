package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Employee;
import com.animalRescue.AnimalRescue.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }


    public Employee create(Employee employee) {
        return repository.save(employee);
    }


    public Employee read(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Employee update(Employee employee) {
        return repository.save(employee);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Set<Employee> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
