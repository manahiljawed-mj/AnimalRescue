package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Employee;
import com.animalRescue.AnimalRescue.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee.Builder()
                .setId(1L)
                .setFirstName("John")
                .setLastName("Doe")
                .setContactNo("1234567890")
                .setEmailAddress("john.doe@example.com")
                .build();
    }

    @Test
    void testCreate() {
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee created = employeeService.create(employee);
        assertNotNull(created);
        assertEquals(employee.getId(), created.getId());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testRead() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Optional<Employee> found = Optional.ofNullable(employeeService.read(1L));
        assertTrue(found.isPresent());
        assertEquals(employee.getId(), found.get().getId());
    }

    @Test
    void testUpdate() {
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee updated = employeeService.update(employee);
        assertNotNull(updated);
        assertEquals(employee.getId(), updated.getId());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testDelete() {
        doNothing().when(employeeRepository).deleteById(1L);
        employeeService.delete(1L);
        verify(employeeRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAll() {
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> allEmployees = (List<Employee>) employeeService.getall();
        assertFalse(allEmployees.isEmpty());
        assertEquals(1, allEmployees.size());
        assertEquals(employee.getId(), allEmployees.get(0).getId());
    }
}
