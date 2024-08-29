package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.Employee;

import java.util.Set;

public interface IEmployeeService extends IService<Employee,Long> {
    Set<Employee> getall();
}
