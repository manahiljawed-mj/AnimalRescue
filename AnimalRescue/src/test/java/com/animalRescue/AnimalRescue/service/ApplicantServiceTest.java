package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Applicant;
import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.PetOwner;
import com.animalRescue.AnimalRescue.factory.ApplicantFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApplicantServiceTest {

    @Autowired
    private ApplicantService applicantService;

    private static Applicant applicant;

    @BeforeEach
    public void setUp() {
        PetOwner petOwner = new PetOwner(); // Initialize as needed
        Dog dog = new Dog(); // Initialize as needed
        Cat cat = new Cat(); // Initialize as needed

        applicant = ApplicantFactory.buildApplicant(petOwner, LocalDate.now(), dog, cat, "Pending");
    }

    @Test
    @Order(1)
    void testCreate() {
        Applicant createdApplicant = applicantService.create(applicant);
        assertNotNull(createdApplicant);
        assertEquals(applicant.getId(), createdApplicant.getId());
        System.out.println("Created: " + createdApplicant);
    }

    @Test
    @Order(2)
    void testRead() {
        Applicant readApplicant = applicantService.read(applicant.getId());
        assertNotNull(readApplicant);
        assertEquals(applicant.getId(), readApplicant.getId());
        System.out.println("Read: " + readApplicant);
    }

    @Test
    @Order(3)
    void testUpdate() {
        Applicant updatedApplicant = new Applicant.Builder()
                .copy(applicant)
                .setStatus("Approved")
                .build();
        Applicant updated = applicantService.update(updatedApplicant);
        assertNotNull(updated);
        assertEquals("Approved", updated.getStatus());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void testDelete() {
        applicantService.delete(applicant.getId());
        Applicant deleted = applicantService.read(applicant.getId());
        assertNull(deleted);
        System.out.println("Deleted");
    }

    @Test
    @Order(5)
    void testGetAll() {
        Set<Applicant> applicants = applicantService.getall();
        assertNotNull(applicants);
        assertFalse(applicants.isEmpty());
        System.out.println("All Applicants: " + applicants);
    }
}
