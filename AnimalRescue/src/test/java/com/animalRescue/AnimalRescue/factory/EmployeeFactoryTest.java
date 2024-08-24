package com.animalRescue.AnimalRescue.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.animalRescue.AnimalRescue.domain.Employee;
import com.animalRescue.AnimalRescue.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeFactoryTest {

    @BeforeEach
    void setUp() {
        // No setup required for Employee tests as no shared state or complex initialization is needed.
    }

    @Test
    void testBuildEmployeeWithId() {
        Employee employee = EmployeeFactory.buildEmployee(1L, "John", "Doe", "123-456-7890", "john.doe@example.com");

        assertNotNull(employee);
        assertEquals(1L, employee.getId());
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("123-456-7890", employee.getContactNo());
        assertEquals("john.doe@example.com", employee.getEmailAddress());
    }

    @Test
    void testBuildEmployeeWithoutId() {
        Employee employee = EmployeeFactory.buildEmployee("Jane", "Smith", "987-654-3210", "jane.smith@example.com");

        assertNotNull(employee);
        assertNotNull(employee.getId());
        assertEquals("Jane", employee.getFirstName());
        assertEquals("Smith", employee.getLastName());
        assertEquals("987-654-3210", employee.getContactNo());
        assertEquals("jane.smith@example.com", employee.getEmailAddress());
    }

    @Test
    void testBuildEmployeeWithInvalidData() {
        Employee employee = EmployeeFactory.buildEmployee(0L, "", "", "", "");

        assertNull(employee);
    }

    @Test
    void testBuildEmployeeWithNullFirstName() {
        Employee employee = EmployeeFactory.buildEmployee(1L, null, "Doe", "123-456-7890", "john.doe@example.com");

        assertNull(employee);
    }

    @Test
    void testBuildEmployeeWithNullLastName() {
        Employee employee = EmployeeFactory.buildEmployee(1L, "John", null, "123-456-7890", "john.doe@example.com");

        assertNull(employee);
    }

    @Test
    void testBuildEmployeeWithNullContactNo() {
        Employee employee = EmployeeFactory.buildEmployee(1L, "John", "Doe", null, "john.doe@example.com");

        assertNull(employee);
    }

    @Test
    void testBuildEmployeeWithNullEmailAddress() {
        Employee employee = EmployeeFactory.buildEmployee(1L, "John", "Doe", "123-456-7890", null);

        assertNull(employee);
    }
}
