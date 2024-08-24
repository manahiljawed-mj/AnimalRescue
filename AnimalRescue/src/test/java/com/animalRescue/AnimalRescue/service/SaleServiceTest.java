package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Applicant;
import com.animalRescue.AnimalRescue.domain.Employee;
import com.animalRescue.AnimalRescue.domain.Sale;
import com.animalRescue.AnimalRescue.repository.SaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SaleServiceTest{

    @InjectMocks
    private SaleService saleService;

    @Mock
    private SaleRepository saleRepository;

    private Sale sale;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        sale = new Sale.Builder()
                .setId(1L)
                .setApplicant(new Applicant()) // Mock or create a proper Applicant instance
                .setEmployee(new Employee())   // Mock or create a proper Employee instance
                .setSaleDate(LocalDate.of(2024, 8, 24))
                .setPrice(99.99)
                .build();
    }

    @Test
    void testCreate() {
        when(saleRepository.save(sale)).thenReturn(sale);
        Sale created = saleService.create(sale);
        assertNotNull(created);
        assertEquals(sale.getId(), created.getId());
        verify(saleRepository, times(1)).save(sale);
    }

    @Test
    void testRead() {
        when(saleRepository.findById(1L)).thenReturn(Optional.of(sale));
        Optional<Sale> found = Optional.ofNullable(saleService.read(1L));
        assertTrue(found.isPresent());
        assertEquals(sale.getId(), found.get().getId());
    }

    @Test
    void testUpdate() {
        when(saleRepository.save(sale)).thenReturn(sale);
        Sale updated = saleService.update(sale);
        assertNotNull(updated);
        assertEquals(sale.getId(), updated.getId());
        verify(saleRepository, times(1)).save(sale);
    }

    @Test
    void testDelete() {
        doNothing().when(saleRepository).deleteById(1L);
        saleService.delete(1L);
        verify(saleRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAll() {
        List<Sale> sales = new ArrayList<>();
        sales.add(sale);
        when(saleRepository.findAll()).thenReturn(sales);
        List<Sale> allSales = (List<Sale>) saleService.getall();
        assertFalse(allSales.isEmpty());
        assertEquals(1, allSales.size());
        assertEquals(sale.getId(), allSales.get(0).getId());
    }
}
