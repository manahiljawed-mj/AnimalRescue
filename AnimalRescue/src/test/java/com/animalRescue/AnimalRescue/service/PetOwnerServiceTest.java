package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.MedicalRecord;
import com.animalRescue.AnimalRescue.domain.PetOwner;
import com.animalRescue.AnimalRescue.factory.PetOwnerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetOwnerServiceTest {

    @Autowired
    private PetOwnerService petOwnerService;

    private static PetOwner petOwner;

    @BeforeEach
    void setUp() {
        petOwner = PetOwnerFactory.buildPetOwner(2,"Manahil","Jawed", "12345678", "abc@gmail.com","abc street");
    }

    @Test
    @Order(1)
    void testCreate() {
        PetOwner createdPetOwner = petOwnerService.create(petOwner);
        assertNotNull(createdPetOwner);
        assertEquals(petOwner.getId(), createdPetOwner.getId());
        System.out.println("Created: " + createdPetOwner);
    }

    @Test
    @Order(2)
    void testRead() {
        PetOwner readPetOwner = petOwnerService.read(petOwner.getId());
        assertNotNull(readPetOwner);
        assertEquals(petOwner.getId(), readPetOwner.getId());
        System.out.println("Read: " + readPetOwner);
    }

    @Test
    @Order(3)
    void testUpdate() {
        PetOwner updatedPetOwner = new PetOwner.Builder()
                .copy(petOwner)
                .setStreetAddress("456 Oak Street")
                .build();
        PetOwner updated = petOwnerService.update(updatedPetOwner);
        assertNotNull(updated);
        assertEquals(updatedPetOwner.getStreetAddress(), updated.getStreetAddress());
        System.out.println("Updated: " + updated);
    }


    @Test
    @Order(4)
    void testGetAll() {
        Set<PetOwner> petOwners = petOwnerService.getall();
        assertNotNull(petOwners);
        assertFalse(petOwners.isEmpty());
        System.out.println("All PetOwners: " + petOwners);
    }

    @Test
    @Order(5)
    void testDelete() {
        petOwnerService.delete(petOwner.getId());
        PetOwner deleted = petOwnerService.read(petOwner.getId());
        assertNull(deleted);
        System.out.println("Deleted");

    }
}
