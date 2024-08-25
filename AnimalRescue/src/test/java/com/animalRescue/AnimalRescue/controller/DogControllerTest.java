package com.animalRescue.AnimalRescue.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.factory.DogFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DogControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/animalRescue/dog";

    private Dog roxy;

    @BeforeEach
    public void setUp() {
        roxy = DogFactory.buildDog(3,"Roxy", "Medium", 8, "Female", "Pitbull", 107);
    }

    @Test
    @Order(1)
    void testCreateDog() {
        String url = BASE_URL + "/create";
        // Log the dog object being sent
        System.out.println("Sending Dog object: " + roxy);
        ResponseEntity<Dog> response = restTemplate.postForEntity(url, roxy, Dog.class);
        // Log the response status and body
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode()); // Change to HttpStatus.OK if needed
        assertNotNull(response.getBody());
        Dog createdDog = response.getBody();
        assertEquals(roxy.getName(), createdDog.getName());
        System.out.println("Created Dog: " + createdDog);


    }

    @Test
    @Order(2)
    void testReadDog() {
        // Ensure the dog is created before reading
        assertNotNull(roxy.getDogId(), "Dog ID should not be null");
        // Correct URL format
        String url = BASE_URL + "/read/" + roxy.getDogId();
        // Log the URL being accessed
        System.out.println("Request URL: " + url);
        ResponseEntity<Dog> response = restTemplate.getForEntity(url, Dog.class);
        // Log the response status and body
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected status code 200 OK");
        assertNotNull(response.getBody(), "Response body should not be null");
        Dog readDog = response.getBody();
        // Log the details of the read dog
        System.out.println("Read Dog: " + readDog);
    }

    @Test
    @Order(3)
    void testUpdateDog() {
        String url = BASE_URL + "/update";
        Dog updatedDog = new Dog.Builder()
                .copy(roxy)
                .setName("Snowy")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Dog> request = new HttpEntity<>(updatedDog, headers);
        // Using exchange method for PUT request
        ResponseEntity<Dog> response = restTemplate.exchange(url, HttpMethod.PUT, request, Dog.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Dog updated = response.getBody();
        assertEquals(updatedDog.getName(), updated.getName());
        System.out.println("Updated Dog: " + updated);
    }


    @Test
    @Order(4)
    void testGetAllDogs() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Set> response = restTemplate.exchange(url, HttpMethod.GET, entity, Set.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
        System.out.println("Show All Dogs: " + response.getBody());
    }

    @Test
    @Order(5)
    void testDeleteDog() {
        // DELETE the dog
        String deleteUrl = BASE_URL + "/delete/" + roxy.getDogId();
        restTemplate.delete(deleteUrl);
        // Verify the deletion by attempting to read the dog
        String readUrl = BASE_URL + "/read/" + roxy.getDogId();
        ResponseEntity<Dog> response = restTemplate.getForEntity(readUrl, Dog.class);
        // Log the result
        System.out.println("Response Status Code after deletion attempt: " + response.getStatusCode());
        System.out.println("Response Body after deletion attempt: " + response.getBody());

    }

}
