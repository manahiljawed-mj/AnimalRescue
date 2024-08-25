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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

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
        PetOwner petOwner = new PetOwner.Builder()
                .setId(1L)
                .setFirstName("John")
                .setLastName("Doe")
                .setContactNo("1234567890")
                .setEmailAddress("abc@gmail.com")
                .setStreetAddress("abc")
                .build();

        Dog dog = new Dog.Builder()
                .setDogId(9L)
                .setName("Buddy")
                .setSize("Large")
                .setAge(5)
                .setGender("Male")
                .setBreed("Golden Retriever")
                .setCageNumber(0)
                .build();

        Cat cat = new Cat.Builder()
                .setCatId(4L)
                .setName("Whiskers")
                .setSize("Large")
                .setAge(3)
                .setGender("Female")
                .setBreed("Siamese")
                .setCageNumber(5)
                .build();

        applicant = ApplicantFactory.buildApplicant(14L,petOwner, LocalDate.now(), dog, cat, "Pending");
    }

    @Test
    @Order(1)
    void testCreateApplicant() {

        String url = BASE_URL + "/create";
        // Log the dog object being sent
        System.out.println("Sending Applicant object: " + applicant);
        ResponseEntity<Applicant> response = restTemplate.postForEntity(url, applicant, Applicant.class);
        // Log the response status and body
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode()); // Change to HttpStatus.OK if needed
        assertNotNull(response.getBody());
        Applicant createdApplicant = response.getBody();
        assertEquals(applicant.getCatId(), createdApplicant.getCatId());
        System.out.println("Created Applicant: " + createdApplicant);
    }

    @Test
    @Order(2)
    void testReadApplicant() {
        // Ensure the dog is created before reading
        assertNotNull(applicant.getId(), "Applicant ID should not be null");
        // Correct URL format
        String url = BASE_URL + "/read/" + applicant.getId();
        // Log the URL being accessed
        System.out.println("Request URL: " + url);
        ResponseEntity<Applicant> response = restTemplate.getForEntity(url, Applicant.class);
        // Log the response status and body
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected status code 200 OK");
        assertNotNull(response.getBody(), "Response body should not be null");
        Applicant readApplicant = response.getBody();
        // Log the details of the read dog
        System.out.println("Read Dog: " + readApplicant);
    }

    @Test
    @Order(3)
    void testUpdateApplicant() {
        String url = BASE_URL + "/update";
        Applicant updatedApplicant = new Applicant.Builder()
                .copy(applicant)
                .setStatus("abc")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Applicant> request = new HttpEntity<>(updatedApplicant, headers);
        // Using exchange method for PUT request
        ResponseEntity<Applicant> response = restTemplate.exchange(url, HttpMethod.PUT, request, Applicant.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Applicant updated = response.getBody();
        assertEquals(updatedApplicant.getId(), updated.getId());
        System.out.println("Updated Applicant: " + updated);
    }

    @Test
    @Order(4)
    void testGetAllApplicants() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Set> response = restTemplate.exchange(url, HttpMethod.GET, entity, Set.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
        System.out.println("Show ALL Applicants: " + response.getBody());
    }

    @Test
    @Order(5)
    void testDeleteApplicant() {
        // DELETE the dog
        String deleteUrl = BASE_URL + "/delete/" + applicant.getId();
        restTemplate.delete(deleteUrl);
        // Verify the deletion by attempting to read the dog
        String readUrl = BASE_URL + "/read/" + applicant.getId();
        ResponseEntity<Applicant> response = restTemplate.getForEntity(readUrl, Applicant.class);
        // Log the result
        System.out.println("Response Status Code after deletion attempt: " + response.getStatusCode());
        System.out.println("Response Body after deletion attempt: " + response.getBody());
    }

}
