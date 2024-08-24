package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.Employee;
import com.animalRescue.AnimalRescue.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    private MockMvc mockMvc;

    private Employee employee;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        employee = new Employee.Builder()
                .setId(1L)
                .setFirstName("John")
                .setLastName("Doe")
                .setContactNo("1234567890")
                .setEmailAddress("john.doe@example.com")
                .build();
    }

    @Test
    void testCreate() throws Exception {
        when(employeeService.create(any(Employee.class))).thenReturn(employee);
        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"contactNo\":\"1234567890\",\"emailAddress\":\"john.doe@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(employee.getId()));
    }

    @Test
    void testRead() throws Exception {
        when(employeeService.read(1L)).thenReturn(employee);
        mockMvc.perform(get("/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(employee.getFirstName()));
    }

    @Test
    void testUpdate() throws Exception {
        when(employeeService.update(any(Employee.class))).thenReturn(employee);
        mockMvc.perform(put("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"contactNo\":\"1234567890\",\"emailAddress\":\"john.doe@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(employee.getFirstName()));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(employeeService).delete(1L);
        mockMvc.perform(delete("/employees/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetAll() throws Exception {
        when(employeeService.getall()).thenReturn((Set<Employee>) List.of(employee));
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value(employee.getFirstName()));
    }
}
