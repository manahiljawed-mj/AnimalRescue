package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.Applicant;
import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.PetOwner;
import com.animalRescue.AnimalRescue.factory.ApplicantFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicantControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/animalRescue/applicant";
    private Applicant applicant;

    @BeforeEach
    public void setUp() {
        PetOwner petOwner = new PetOwner(); // Initialize as needed
        Dog dog = new Dog(); // Initialize as needed
        Cat cat = new Cat(); // Initialize as needed

        applicant = ApplicantFactory.buildApplicant(petOwner, LocalDate.now(), dog, cat, "Pending");
    }

    @Test
    @Order(1)
    void testCreateApplicant() {
        String url = BASE_URL + "/create";
        ResponseEntity<Applicant> response = restTemplate.postForEntity(url, applicant, Applicant.class);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        Applicant createdApplicant = response.getBody();
        assertEquals(applicant.getId(), createdApplicant.getId());
        System.out.println("Created Applicant: " + createdApplicant);
    }

    @Test
    @Order(2)
    void testReadApplicant() {
        String url = BASE_URL + "/read/" + applicant.getId();
        ResponseEntity<Applicant> response = restTemplate.getForEntity(url, Applicant.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Applicant readApplicant = response.getBody();
        assertEquals(applicant.getId(), readApplicant.getId());
        System.out.println("Read Applicant: " + readApplicant);
    }

    @Test
    @Order(3)
    void testUpdateApplicant() {
        String url = BASE_URL + "/update";
        Applicant updatedApplicant = new Applicant.Builder()
                .copy(applicant)
                .setStatus("Approved")
                .build();
        ResponseEntity<Applicant> response = restTemplate.postForEntity(url, updatedApplicant, Applicant.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Applicant updated = response.getBody();
        assertEquals("Approved", updated.getStatus());
        System.out.println("Updated Applicant: " + updated);
    }

    @Test
    @Order(4)
    void testDeleteApplicant() {
        String url = BASE_URL + "/delete/" + applicant.getId();
        restTemplate.delete(url);
        String deleteUrl = BASE_URL + "/read/" + applicant.getId();
        ResponseEntity<Applicant> response = restTemplate.getForEntity(deleteUrl, Applicant.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        System.out.println("Deleted Applicant (verified by read attempt)");
    }

    @Test
    @Order(5)
    void testGetAllApplicants() {
        String url = BASE_URL + "/getall";
        ResponseEntity<Applicant[]> response = restTemplate.getForEntity(url, Applicant[].class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("Show All Applicants: " + response.getBody());
    }
}
