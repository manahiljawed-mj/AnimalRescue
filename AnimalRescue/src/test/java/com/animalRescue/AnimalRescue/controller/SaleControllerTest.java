package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.Applicant;
import com.animalRescue.AnimalRescue.domain.Employee;
import com.animalRescue.AnimalRescue.domain.Sale;
import com.animalRescue.AnimalRescue.service.SaleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(SaleController.class)
public class SaleControllerTest {

    @InjectMocks
    private SaleController saleController;

    @Mock
    private SaleService saleService;

    private MockMvc mockMvc;

    private Sale sale;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(saleController).build();
        sale = new Sale.Builder()
                .setId(1L)
                .setApplicant(new Applicant()) // Mock or create a proper Applicant instance
                .setEmployee(new Employee())   // Mock or create a proper Employee instance
                .setSaleDate(LocalDate.of(2024, 8, 24))
                .setPrice(99.99)
                .build();
    }

    @Test
    void testCreate() throws Exception {
        when(saleService.create(any(Sale.class))).thenReturn(sale);
        mockMvc.perform(post("/sales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"applicant\":{\"id\":1},\"employee\":{\"id\":1},\"saleDate\":\"2024-08-24\",\"price\":99.99}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(sale.getId()));
    }

    @Test
    void testRead() throws Exception {
        when(saleService.read(1L)).thenReturn(sale);
        mockMvc.perform(get("/sales/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(sale.getPrice()));
    }

    @Test
    void testUpdate() throws Exception {
        when(saleService.update(any(Sale.class))).thenReturn(sale);
        mockMvc.perform(put("/sales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"applicant\":{\"id\":1},\"employee\":{\"id\":1},\"saleDate\":\"2024-08-24\",\"price\":99.99}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(sale.getPrice()));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(saleService).delete(1L);
        mockMvc.perform(delete("/sales/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetAll() throws Exception {
        when(saleService.getall()).thenReturn((Set<Sale>) List.of(sale));
        mockMvc.perform(get("/sales"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].price").value(sale.getPrice()));
    }
}
