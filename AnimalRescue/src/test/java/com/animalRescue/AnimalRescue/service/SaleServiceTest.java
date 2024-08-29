package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.*;
import com.animalRescue.AnimalRescue.factory.SaleFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SaleServiceTest {

    @Autowired
    private SaleService saleService;

    private static Sale sale;

    @BeforeEach
    void setUp() {
        PetOwner petOwner = new PetOwner.Builder()
                .setId(1L)
                .setFirstName("John")
                .setLastName("Doe")
                .setContactNo("1234567890")
                .setEmailAddress("abc@gmail.com")
                .setStreetAddress("abc")
                .build();

        Dog dog = new Dog.Builder()
                .setDogId(1L)
                .setName("Buddy")
                .setSize("Large")
                .setAge(5)
                .setGender("Male")
                .setBreed("Golden Retriever")
                .setCageNumber(0)
                .build();

        Cat cat = new Cat.Builder()
                .setCatId(2L)
                .setName("Whiskers")
                .setSize("Large")
                .setAge(3)
                .setGender("Female")
                .setBreed("Siamese")
                .setCageNumber(5)
                .build();

        Applicant applicant= new Applicant.Builder()
                .setId(1L)
                .setCatId(cat)
                .setDogId(dog)
                .setPetOwner(petOwner)
                .setStatus("processing")
                .setApplicationDate(LocalDate.now())
                .build();

        Employee employee=new Employee.Builder()
                .setFirstName("Manahil")
                .setLastName("Jawed")
                .setContactNo("1234")
                .setEmailAddress("abc@gmail.com")
                .setId(3L)
                .build();

        sale= SaleFactory.buildSale(1L,applicant,employee,LocalDate.now(),785.2);
    }

    @Test
    @Order(1)
    void testCreate() {
        Sale createdSale = saleService.create(sale);
        assertNotNull(createdSale);
        assertEquals(sale.getSaleDate(), createdSale.getSaleDate());
        System.out.println("Created: " + createdSale);
    }

    @Test
    @Order(2)
    void testRead() {
        Sale readSale = saleService.read(sale.getId());
        assertNotNull(readSale);
        assertEquals(sale.getSaleDate(), readSale.getSaleDate());
        System.out.println("Read: " + readSale);
    }

    @Test
    @Order(3)
    void testUpdate() {
        Sale updatedSale = new Sale.Builder()
                .copy(sale)
                .setPrice(109.99)
                .build();
        Sale updated = saleService.update(updatedSale);
        assertNotNull(updated);
        assertEquals(updatedSale.getPrice(), updated.getPrice());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void testGetAll() {
        Set<Sale> sales = saleService.getall();
        assertNotNull(sales);
        assertFalse(sales.isEmpty());
        System.out.println("All Sales: " + sales);
    }

    @Test
    @Order(5)
    void testDelete() {
        saleService.delete(sale.getId());
        Sale deleted = saleService.read(sale.getId());
        assertNull(deleted);
        System.out.println("Deleted");
    }

}
